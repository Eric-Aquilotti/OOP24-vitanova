package it.unibo.model.chapter.quadtree;

import java.util.List;

import it.unibo.common.Circle;

/**
 * Models a data structure that allows the retrieval of points inside a
 * given range in O(logn) time complexity.
 */
public interface QuadTree {
    /**
     * 
     * @param point the point to insert in the tree.
     * @return true if the point was inserted.
     */
    boolean insert(Point point);

    /**
     * Fills the found list with the points that are inside the given range.
     * @param range the range to check.
     * @param found the list to fill.
     */
    void query(Circle range, List<Point> found);
}
