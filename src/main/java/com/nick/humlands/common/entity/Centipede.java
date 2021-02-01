package com.nick.humlands.common.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class Centipede extends MonsterEntity
{
	public Centipede(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public int chargeAttackTimer = 0;

	
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setCreateFog(true).setDarkenSky(true);
	public void readAdditional(CompoundNBT compound) {
	      super.readAdditional(compound);
	      if (this.hasCustomName()) {
	         this.bossInfo.setName(this.getDisplayName());
	      }

	   }

	   public void setCustomName(@Nullable ITextComponent name) 
	   {
	      super.setCustomName(name);
	      this.bossInfo.setName(this.getDisplayName());
	   }

	   @Override
	    protected void registerGoals() {
	        this.targetSelector.addGoal(0, (new HurtByTargetGoal(this)));
	        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, (double)1.5f, false));
	        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	    }
	   
	public static AttributeModifierMap.MutableAttribute registerAttributes() 
	{
        return MonsterEntity.registerAttributes()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)1.5f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2.0f);
        
    }
	
	@Override
	protected void updateAITasks() {
		
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	public void addTrackingPlayer(ServerPlayerEntity player) {
	      super.addTrackingPlayer(player);
	      this.bossInfo.addPlayer(player);
	   }
	public void removeTrackingPlayer(ServerPlayerEntity player) {
	      super.removeTrackingPlayer(player);
	      this.bossInfo.removePlayer(player);
	   }
	
	static class AttackGoal extends MeleeAttackGoal 
	{
	      public AttackGoal(Centipede centipede) 
	      {
	         super(centipede, 1.0D, true);
	      }
	}
	
	static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> 
	{
	      public TargetGoal(Centipede centipede, Class<T> classTarget) 
	      {
	         super(centipede, classTarget, true);
	      }
	}
	
	static class ChargeAttackGoal extends MeleeAttackGoal
	{

		private Centipede centipede;
		
		public ChargeAttackGoal(Centipede creature)
		{
			super(creature, 1.0D, true);
			centipede = creature;
		}
		
		@Override
		public void startExecuting() 
		{
			centipede.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)1.0f);
			centipede.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(10.0f);
			centipede.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(15.0f);
			centipede.chargeAttackTimer = 100;
		}	
		
		public void tick() {
			super.tick();
			if (centipede.chargeAttackTimer > 0) {
				centipede.chargeAttackTimer--;
				if (centipede.chargeAttackTimer == 0) {
					centipede.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
					centipede.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
					centipede.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100.0D);
					

				}
			}
		}
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) 
	{
		return 0.5F;
	}
	
	@Override
	public boolean isNonBoss() 
	{
		return false;
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) 
	{
		
		return false;
	}
	
	
	
	
}
