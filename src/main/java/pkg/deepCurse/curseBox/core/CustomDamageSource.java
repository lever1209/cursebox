package pkg.deepCurse.curseBox.core;

import net.minecraft.entity.damage.DamageSource;

public class CustomDamageSource extends DamageSource {
	protected boolean fire;
	public static final DamageSource GRUE = new CustomDamageSource("cursebox.darkness");

	protected CustomDamageSource(String name) {
		super(name);
	}

	protected CustomDamageSource setFire() {
		this.fire = true;
		return this;
	}
}