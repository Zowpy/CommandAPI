package me.zowpy.commandapi.command;

import net.dv8tion.jda.api.Permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Project is property of Zowpy © 2021
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandMeta {

    String name();
    Permission permission() default Permission.UNKNOWN;

}
