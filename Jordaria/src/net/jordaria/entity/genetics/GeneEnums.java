package net.jordaria.entity.genetics;

public class GeneEnums {
	public enum genePosition{
		HEALTH(0),
		SIZE(1),
		MOVE_SPEED(2);
		
		int pos;
		private genePosition(int value){
			this.pos = value;
		}
	}
	public enum size{
		TINY((byte)0),
		VERY_SMALL((byte)1),
		SMALL((byte)2),
		MEDIUM((byte)3),
		LARGE((byte)4),
		VERY_LARGE((byte)5),
		HUGE((byte)6);
		
		byte geneData;
		private size(byte value){
			this.geneData = value;
		}
	}
	public enum moveSpeed{
		VERY_SLOW((byte)0),
		SLOW((byte)1),
		NORMAL((byte)2),
		FAST((byte)3),
		VERY_FAST((byte)4);
		
		byte geneData;
		private moveSpeed(byte value){
			this.geneData = value;
		}
	}
	public enum health{
		LARGE_REDUCTION((byte)0),
		SMALL_REDUCTION((byte)1),
		NORMAL((byte)2),
		SMALL_INCREASE((byte)3),
		LARGE_INCREASE((byte)4);
		
		byte geneData;
		private health(byte value){
			this.geneData = value;
		}
	}
}
