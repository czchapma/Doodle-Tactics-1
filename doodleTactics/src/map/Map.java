package map;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

import util.Heap;

/**
 * 
 * @author rroelke
 * a Map is a segment of the game world during which gameplay occurs
 */
public class Map {
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	private Tile _overflow;
	private Tile[][] _map;
	String _name;
	
	/**
	 * parses a map to generate a map instance
	 * @param file the file to parse from
	 * @return
	 */
	public static Map map(String file) throws InvalidMapException {
		return null;
	}
	
	/**
	 * returns an estimate for the distance between two tiles
	 * heuristic function used for A* pathfinding
	 * @param source the start tile
	 * @param dest the end tile
	 * @return an estimate of the distance between the two tiles
	 */
	private int estimateDistance(Tile source, Tile dest) {
		return Math.abs(source.x() - dest.x()) + Math.abs(source.y() - dest.y());
	}
	
	/**
	 * generates a path from the source tile to the destination tile
	 * @param source the tile to start from
	 * @param dest the tile to end at
	 * @return an ordered list of all tiles in the path
	 */
	public List<Tile> getPath(Tile source, Tile dest) {
		final Hashtable<Tile, Integer> distances = new Hashtable<Tile, Integer>();
		Hashtable<Tile, Tile> previous = new Hashtable<Tile, Tile>();
		Heap<Tile> heap = new Heap<Tile>(estimateDistance(source, dest),
				new Comparator<Tile>() {

					@Override
					public int compare(Tile o1, Tile o2) {
						int d1 = distances.get(o1);
						int d2 = distances.get(o2);
						if (d1 < d2)
							return -1;
						else if (d1 == d2)
							return 0;
						else
							return 1;
					}
			
		});
		
		distances.put(source, 0);
		
		Tile consider = source;
		while (distances.get(dest) == null) {
			
		}
		
		return null;
	}
	
	/**
	 * lists all tiles that can be reached from the source tile with the given range
	 * @param source the tile to start from
	 * @param range the total cost of movement allowable
	 * @return an unordered list of all tiles that can be reached from the source 
	 */
	public List<Tile> getMovementRange(Tile source, int range) {
		return null;
	}
	
	/**
	 * lists all tiles that could be attacked from the source tile with the given movement and attack ranges
	 * @param source
	 * @param movementRange
	 * @param attackRange
	 * @return an unordered list of tiles that could be attacked from the source tile
	 */
	public List<Tile> getAttackRange(Tile source, int movementRange, int attackRange) {
		return getMovementRange(source, movementRange);
	}
}
