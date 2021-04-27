package com.dream.utils;

import org.bukkit.enchantments.Enchantment;

public enum EnchantmentName {
	
	ARROW_DAMAGE("Força"),
	ARROW_FIRE("Chama"),
	ARROW_INFINITE("Infinidade"),
	ARROW_KNOCKBACK("Impacto"),
	BINDING_CURSE("Maldição da Lssigação"),
	CHANNELING("Condutividade"),
	DAMAGE_ALL("Afiação"),
	DAMAGE_ARTHROPODS("Ruína dos Artrópodes"),
	DAMAGE_UNDEAD("Julgamento"),
	DEPTH_STRIDER("Passos Profundos"),
	DIG_SPEED("Eficiência"),
	DURABILITY("Inquebrável"),
	FIRE_ASPECT("Aspecto Flamejante"),
	FROST_WALKER("Passos Gelados"),
	IMPALING("Penetração"),
	KNOCKBACK("Repulsão"),
	LOOT_BONUS_BLOCKS("Fortuna"),
	LOOT_BONUS_MOBS("Pilhagem"),
	LOYALTY("Lealdade"),
	LUCK("Sorte do Mar"),
	LURE("Isca"),
	MENDING("Remendo"),
	MULTISHOT("Tiro Múltiplo"),
	OXYGEN("Respiração"),
	PIERCING("Perfuração"),
	PROTECTION_ENVIRONMENTAL("Proteção"),
	PROTECTION_EXPLOSIONS("Proteção contra Explosões"),
	PROTECTION_FALL("Peso pena"),
	PROTECTION_FIRE("Proteção contra o Fogo"),
	PROTECTION_PROJECTILE("Proteção contra Projéteis"),
	QUICK_CHARGE("Carga Rápida"),
	RIPTIDE("Correnteza"),
	SILK_TOUCH("Toque Suave"),
	SOUL_SPEED("Velocidade das Almas"),
	SWEEPING_EDGE("Alcance"),
	THORNS("Espinhos"),
	VANISHING_CURSE("Maldição do Desaparecimento"),
	WATER_WORKER("Afinidade Aquática");

	private String name;
	
	EnchantmentName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static EnchantmentName valueOf(Enchantment enchantment) {
		return EnchantmentName.valueOf(enchantment.getName());
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}