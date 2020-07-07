package dev.rosewood.rosestacker.stack.settings.entity;

import dev.rosewood.rosestacker.config.CommentedFileConfiguration;
import dev.rosewood.rosestacker.stack.StackedEntity;
import dev.rosewood.rosestacker.stack.settings.EntityStackSettings;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class ChickenStackSettings extends EntityStackSettings {

    private boolean multiplyEggDropsByStackSize;

    public ChickenStackSettings(CommentedFileConfiguration entitySettingsFileConfiguration) {
        super(entitySettingsFileConfiguration);

        this.multiplyEggDropsByStackSize = this.settingsConfiguration.getBoolean("multiply-egg-drops-by-stack-size");
    }

    @Override
    protected boolean canStackWithInternal(StackedEntity stack1, StackedEntity stack2) {
        return true;
    }

    @Override
    protected void setDefaultsInternal() {
        this.setIfNotExists("multiply-egg-drops-by-stack-size", true);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.CHICKEN;
    }

    @Override
    public Material getSpawnEggMaterial() {
        return Material.CHICKEN_SPAWN_EGG;
    }

    public boolean shouldMultiplyEggDropsByStackSize() {
        return this.multiplyEggDropsByStackSize;
    }

}