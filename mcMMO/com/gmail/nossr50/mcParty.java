package com.gmail.nossr50;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class mcParty {
	private static mcMMO plugin;
	public mcParty(mcMMO instance) {
    	plugin = instance;
    }
	private static volatile mcParty instance;
	public static mcParty getInstance() {
    	if (instance == null) {
    	instance = new mcParty(plugin);
    	}
    	return instance;
    	}
    public boolean inSameParty(Player playera, Player playerb){
    	if(mcUsers.getProfile(playera.getName()) == null || mcUsers.getProfile(playerb.getName()) == null){
    		mcUsers.addUser(playera);
    		mcUsers.addUser(playerb);
    	}
    	if(mcUsers.getProfile(playera.getName()).inParty() && mcUsers.getProfile(playerb.getName()).inParty()){
	        if(mcUsers.getProfile(playera.getName()).getParty().equals(mcUsers.getProfile(playerb.getName()).getParty())){
	            return true;
	        } else {
	            return false;
	        }
    	} else {
    		return false;
    	}
    }
    
	public int partyCount(Player player, Player[] players){
        int x = 0;
        for(Player hurrdurr : players){
        	if(player != null && hurrdurr != null){
        	if(mcUsers.getProfile(player.getName()).getParty().equals(mcUsers.getProfile(hurrdurr.getName()).getParty()))
        	x++;
        	}
        }
        return x;
    }
    public void informPartyMembers(Player player, Player[] players){
        int x = 0;
        for(Player p : players){
        	if(player != null && p != null){
                if(inSameParty(player, p) && !p.getName().equals(player.getName())){
                p.sendMessage(player.getName() + ChatColor.GREEN + " has joined your party");
                x++;
                }
            }
        }
    }
    public void informPartyMembersQuit(Player player, Player[] players){
        int x = 0;
        for(Player p : players){
        		if(player != null && p != null){
                if(inSameParty(player, p) && !p.getName().equals(player.getName())){
                p.sendMessage(player.getName() + ChatColor.GREEN + " has left your party");
                x++;
                }
        		}
            }
    }

}
