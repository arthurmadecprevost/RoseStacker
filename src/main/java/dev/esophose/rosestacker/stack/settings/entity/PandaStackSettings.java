package dev.esophose.rosestacker.stack.settings.entity;

import dev.esophose.rosestacker.config.CommentedFileConfiguration;
import dev.esophose.rosestacker.stack.StackedEntity;
import dev.esophose.rosestacker.stack.settings.EntityStackSettings;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Panda;

public class PandaStackSettings extends EntityStackSettings {

    private boolean dontStackIfDifferentMainGene;
    private boolean dontStackIfDifferentRecessiveGene;

    public PandaStackSettings(CommentedFileConfiguration entitySettingsFileConfiguration) {
        super(entitySettingsFileConfiguration);

        this.dontStackIfDifferentMainGene = this.entitySettingsConfiguration.getBoolean("dont-stack-if-different-main-gene");
        this.dontStackIfDifferentRecessiveGene = this.entitySettingsConfiguration.getBoolean("dont-stack-if-different-recessive-gene");
    }

    @Override
    protected boolean canStackWithInternal(StackedEntity stack1, StackedEntity stack2) {
        Panda panda1 = (Panda) stack1.getEntity();
        Panda panda2 = (Panda) stack2.getEntity();

        if (this.dontStackIfDifferentMainGene && panda1.getMainGene() != panda2.getMainGene())
            return false;

        return !this.dontStackIfDifferentRecessiveGene || (panda1.getHiddenGene() == panda2.getHiddenGene());
    }

    @Override
    protected void setDefaultsInternal() {
        this.setIfNotExists("dont-stack-if-different-main-gene", false);
        this.setIfNotExists("dont-stack-if-different-recessive-gene", false);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.PANDA;
    }

}