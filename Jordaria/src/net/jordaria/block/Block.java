package net.jordaria.block;

public class Block {
	private boolean isActive;

	public static final Block[] blocksList = new Block[4096];
	
	public static final Block stone = new BlockStone(1);
	public static final Block grass = new BlockGrass(2);
	
	
	public final int blockID;

	//Local coordinates
	protected double minX;
	protected double minY;
	protected double minZ;
	protected double maxX;
	protected double maxY;
	protected double maxZ;

	protected Block(int id){

		if (blocksList[id] != null){
			throw new IllegalArgumentException("Slot " + id + " is already occupied by " + blocksList[id] + " when adding " + this);
		}
		else{
			blocksList[id] = this;
			this.blockID = id;
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	protected final void setBlockBounds(float minX, float minY, float minZ, float maxX, float maxY, float maxZ){
		this.minX = (double)minX;
		this.minY = (double)minY;
		this.minZ = (double)minZ;
		this.maxX = (double)maxX;
		this.maxY = (double)maxY;
		this.maxZ = (double)maxZ;
	}

}
