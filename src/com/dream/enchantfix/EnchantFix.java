package com.dream.enchantfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.dream.packetwrapper.WrapperPlayServerSetSlot;
import com.dream.packetwrapper.WrapperPlayServerWindowItems;
import com.dream.utils.EnchantmentName;

public class EnchantFix extends JavaPlugin {

	private ProtocolManager protocolManager;
	
	public void onEnable() {
		protocolManager = ProtocolLibrary.getProtocolManager();
		
		protocolManager.addPacketListener(new PacketAdapter(this,
		        ListenerPriority.NORMAL,
		        PacketType.Play.Server.SET_SLOT, PacketType.Play.Server.WINDOW_ITEMS) {
		    @Override
		    public void onPacketSending(PacketEvent event) {
		        if (event.getPacketType() == PacketType.Play.Server.SET_SLOT) {
		            PacketContainer packet = event.getPacket();
		            WrapperPlayServerSetSlot packetWrapper = new WrapperPlayServerSetSlot(packet);
		            
		            if(packetWrapper.getSlotData() != null) {
		            	ItemStack stack = packetWrapper.getSlotData().clone();
		            	
		            	if(stack == null || stack.getType() == Material.AIR) {
		            		
		            	} else if(stack.getType() == Material.ENCHANTED_BOOK) {
		            		EnchantmentStorageMeta meta = (EnchantmentStorageMeta)stack.getItemMeta().clone();
		            		if(!meta.getStoredEnchants().isEmpty()) {
		            			if(!meta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)) {
		            				List<String> oldLore = meta.getLore();
		            			
			            			List<String> enchantmentLore = new ArrayList<>();
				            		
			            			for(Enchantment ench : meta.getStoredEnchants().keySet()) {
			            				enchantmentLore.add("§7" + EnchantmentName.valueOf(ench) + " " + meta.getStoredEnchants().get(ench));
			            			}
				            			
			            			if(oldLore != null) {
			            				if(!oldLore.isEmpty()) {
			            					enchantmentLore.add("");
			            					for(String line : oldLore) {
			            						enchantmentLore.add(line);
			            					}
			            				}
			            			}
				            			
			            			meta.setLore(enchantmentLore);
				            		
			            			meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
				            		
			            			stack.setItemMeta(meta);
		            			}
		            		}
		            	} else {
		            		ItemMeta meta = stack.getItemMeta().clone();
		            			
		            		if(!meta.getEnchants().isEmpty()) {
		            			if(!meta.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
			            			List<String> oldLore = meta.getLore();
		            			
			            			List<String> enchantmentLore = new ArrayList<>();
			            			
			            			for(Enchantment ench : stack.getEnchantments().keySet()) {
			            				enchantmentLore.add("§7" + EnchantmentName.valueOf(ench) + " " + stack.getEnchantments().get(ench));
			            			}	
			            			
			            			if(oldLore != null) {
			            				if(!oldLore.isEmpty()) {
			            					enchantmentLore.add("");
			            					for(String line : oldLore) {
			            						enchantmentLore.add(line);
			            					}
			            				}
			            			}
			            			
			            			meta.setLore(enchantmentLore);
			            		
			            			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			            			
			            			stack.setItemMeta(meta);
		            			}
		            		}
		            	}
		            		
		            	packetWrapper.setSlotData(stack);
		            }
		        }
		        
		        if (event.getPacketType() == PacketType.Play.Server.WINDOW_ITEMS) {
		            PacketContainer packet = event.getPacket();
		            WrapperPlayServerWindowItems packetWrapper = new WrapperPlayServerWindowItems(packet);
		            
		            int slot = 0;
		            ItemStack[] itemArray = packetWrapper.getSlotData().clone();
		            for(ItemStack item : itemArray) {
		            	ItemStack stack = item.clone();
		            		
		            	if(stack == null || stack.getType() == Material.AIR) {
		            		
		            	} else if(stack.getType() == Material.ENCHANTED_BOOK) {
		            		EnchantmentStorageMeta meta = (EnchantmentStorageMeta)stack.getItemMeta().clone();
		            		if(!meta.getStoredEnchants().isEmpty()) {
		            			if(!meta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)) {
		            				List<String> oldLore = meta.getLore();
		            			
			            			List<String> enchantmentLore = new ArrayList<>();
				            		
			            			for(Enchantment ench : meta.getStoredEnchants().keySet()) {
			            				enchantmentLore.add("§7" + EnchantmentName.valueOf(ench) + " " + meta.getStoredEnchants().get(ench));
			            			}
				            			
			            			if(oldLore != null) {
			            				if(!oldLore.isEmpty()) {
			            					enchantmentLore.add("");
			            					for(String line : oldLore) {
			            						enchantmentLore.add(line);
			            					}
			            				}
			            			}
				            			
			            			meta.setLore(enchantmentLore);
				            		
			            			meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
				            		
			            			stack.setItemMeta(meta);
		            			}
		            		}
		            	} else {
		            		ItemMeta meta = stack.getItemMeta().clone();
		            			
		            		if(!meta.getEnchants().isEmpty()) {
		            			if(!meta.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
			            			List<String> oldLore = meta.getLore();
		            			
			            			List<String> enchantmentLore = new ArrayList<>();
			            			
			            			for(Enchantment ench : stack.getEnchantments().keySet()) {
			            				enchantmentLore.add("§7" + EnchantmentName.valueOf(ench) + " " + stack.getEnchantments().get(ench));
			            			}	
			            			
			            			if(oldLore != null) {
			            				if(!oldLore.isEmpty()) {
			            					enchantmentLore.add("");
			            					for(String line : oldLore) {
			            						enchantmentLore.add(line);
			            					}
			            				}
			            			}
			            			
			            			meta.setLore(enchantmentLore);
			            		
			            			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			            			
			            			stack.setItemMeta(meta);
		            			}
		            		}
		            	}
		            		
		            	itemArray[slot] = stack;
		            	slot++;
		            }
		            
		            packetWrapper.setSlotData(itemArray);
		        }
		    }
		});
	}
}
