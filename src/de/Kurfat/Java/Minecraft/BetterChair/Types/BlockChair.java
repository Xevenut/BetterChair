package de.Kurfat.Java.Minecraft.BetterChair.Types;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import de.Kurfat.Java.Minecraft.BetterChair.EntityPassengerRotate.EntityPassengerRotateEvent;
import de.Kurfat.Java.Minecraft.BetterChair.BetterChair.ChairType;

public class BlockChair extends Chair {
	
	public static final List<String> BLOCKLIST = Arrays.asList(
		"\\w*_PRESSURE_PLATE",
		"\\w*_*LANTERN",
		"(\\w*_{0,1}AMETHYST_{0,1}\\w*)",
		"POINTED_DRIPSTONE",
		"DEAD_HORN_CORAL",
		"LIGHTNING_ROD",
		"\\w*_*GLASS_PANE"
	);

	public BlockChair(Player player, Block block) throws Exception {
		super(player, block, block.getLocation().clone().add(0.5, -0.7, 0.5));
		Material bottom = block.getType();
		Material upper = block.getLocation().add(0, 1, 0).getBlock().getType();
		if(bottom.isSolid() == false || bottom.isInteractable() || upper.isAir() == false) throw new Exception("This type is not allowed: " + block.toString());
		for(String regex : BLOCKLIST) if(Pattern.matches("^(" + regex + ")$", block.getType().name())) throw new Exception("This type is not allowed: " + block.toString());
	}

	@Override
	public ChairType getType() {
		return ChairType.BLOCK;
	}
	
	@EventHandler
	public void onEntityPassengerRotate(EntityPassengerRotateEvent event) {
		if(event.getEntity().equals(player)) armorStand.setRotation(event.getNewLocation().getYaw(), 0);
	}

}
