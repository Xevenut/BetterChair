package de.Kurfat.Java.Minecraft.BetterChair;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import de.Kurfat.Java.Minecraft.BetterChair.Settings.Settings;

public class PlayerSitEvent extends PlayerEvent{
	
	public static HandlerList HANDLERS = new HandlerList();
	
	private Settings settings;
	private boolean enable;
	
	public PlayerSitEvent(Player player, Settings settings, boolean enable) {
		super(player);
		this.settings = settings;
		this.enable = enable;
	}

	public Settings getSettings() {
		return settings;
	}
	public boolean isEnable() {
		return enable;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}
