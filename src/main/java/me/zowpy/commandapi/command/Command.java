package me.zowpy.commandapi.command;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.Permission;

/**
 * This Project is property of Zowpy © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */

@Getter @Setter
public class Command {

    private final String name;
    private Permission permission;
    private boolean needPermission;

    public Command(String name) {
        this.name = name;
        this.permission = Permission.UNKNOWN;
    }

    public Command(String name, Permission permission) {
        this.name = name;
        this.permission = permission;
        this.needPermission = true;
    }

}
