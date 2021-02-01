package com.nick.humlands.common.entity;

import javax.annotation.Nullable;

import com.nick.humlands.core.init.EntityTypesInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRideable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Humadillo extends TameableEntity implements IRideable {
	private static final DataParameter<Boolean> CLOSED = EntityDataManager.createKey(Humadillo.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> RIDDEN = EntityDataManager.createKey(Humadillo.class,
			DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM);
	private EntitySize size = new EntitySize(1.0f, 1.0f, true);

	public int timer = 0;

	public Humadillo(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public EntitySize getSize(Pose poseIn) {
		return this.size;
	}
	
	@Override
	protected void registerGoals() {

		super.registerGoals();
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 5.0f));

	}
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
	        return TameableEntity.registerAttributes()
	                .createMutableAttribute(Attributes.MAX_HEALTH, 15.0D)
	                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.3f)
	                .createMutableAttribute(Attributes.FOLLOW_RANGE, 10.0D);
	        
	    }

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(CLOSED, false);
		this.dataManager.register(RIDDEN, false);
	}

	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
			this.setHealth(20.0F);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(12.0D);
		}

		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	/* When the timer's over, the humadillo is out of his shell, the timer lasts 20
	   seconds,
	   in which he will have resistance, movement speed set to zero and he will be
	   in his shell.*/
	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount) {

		super.damageEntity(damageSrc, damageAmount);
		this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 140, 20, false, false));
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0f);
		this.setClosed(true);
		timer = 140;
	}

	public void tick() {
		super.tick();
		if (timer > 0) {
			timer--;
			if (timer == 0) {
				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.20f);
				this.setClosed(false);

			}
		}
	}

	@Override
	public boolean canBeLeashedTo(PlayerEntity player) {
		return true;
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}

	public void setClosed(boolean closed) {
		this.dataManager.set(CLOSED, closed);
	}

	public boolean isClosed() {
		return this.dataManager.get(CLOSED);
	}

	public void setRidden(boolean ridden) {
		this.dataManager.set(RIDDEN, ridden);
	}

	public boolean isRidden() {
		return this.dataManager.get(RIDDEN);
	}

	/* Checks if the player right clicks the Humadillo with a mushroom, and if he
	 does, the entity is tamed and rideable.*/
	public boolean processInteract(PlayerEntity player, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);
		Item item = stack.getItem();
		if (item == Items.BROWN_MUSHROOM) {
			this.setRidden(true);
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			return true;
		}

		if (item == Items.RED_MUSHROOM) {
			this.setRidden(true);
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			return true;
		}

		if (this.isRidden() == true && !this.isBeingRidden()) {
			if (!this.world.isRemote) {
				player.startRiding(this);
				return true;
			}
		}
		return false;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();

		if (entity instanceof PlayerEntity) {
			return true;
		}
		return false;
	}

	public double getMountedYOffset() {
		return (double) this.size.height * 0.50D;
	}

	class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
		@SuppressWarnings("unused")
		private final Humadillo humadillo;

		public AvoidEntityGoal(Humadillo humadilloIn, Class<T> p_i47251_3_, float p_i47251_4_, double p_i47251_5_,
				double p_i47251_7_) {
			super(humadilloIn, p_i47251_3_, p_i47251_4_, p_i47251_5_, p_i47251_7_);
			this.humadillo = humadilloIn;
		}
	}

	public Humadillo func_241840_a(ServerWorld world, AgeableEntity entity) {
	      return EntityTypesInit.HUMADILLO.get().create(world);
	   }

	@Override
	public boolean boost() {
		
		return false;
	}

	@Override
	public void travelTowards(Vector3d travelVec) {
		
		
	}

	@Override
	public float getMountedSpeed() {
	
		return 0.6f;
	}

	@Override
	public float getEyeHeight(Pose pose) {
	
		return 0.4f;
	}
}