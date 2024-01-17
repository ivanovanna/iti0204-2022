package ee.ttu.algoritmid.horseracing;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Optional;
import java.util.List;

// Нод для бинарного дерева брала вот с этого сайта https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java
// https://examples.javacodegeeks.com/java-node-example/
class Node {

 private RacingParticipant particip;
 private Node left;
 private Node right;
 private Node parent;


 public Node(RacingParticipant particip) {
  this.particip = particip;
 }

 public Node getRight() {
  return right;
 }

 public Node getLeft() {
  return left;
 }

 public Node getParent() {
  return parent;
 }

 public RacingParticipant getParticip() {
  return particip;
 }

 public void setRight(Node right) {
  this.right = right;
 }

 public void setLeft(Node left) {
  this.left = left;
 }

 public void setParent(Node parent) {
  this.parent = parent;
 }

 public void setParticip(RacingParticipant particip) {
  this.particip = particip;
 }
}


public class BinarySearchTree {

 private Node root;

 public Node getMin(Node node) {
  while (node.getLeft() != null) {
   node = node.getLeft();
  }
  return node;
 }

 public Node getSuccessor(Node node) {
  if (node.getRight() != null) {
   return getMin(node.getRight());
  }
  Node y = node.getParent();
  while (y != null && node == y.getRight()) {
   node = y;
   y = y.getParent();
  }
  return y;
 }

 public Node findBigger(double value, double element) {
  Node selected = null;
  Node node = root;
  double best_match_distance = 15;
  double difference;

  if (root == null) {
   return null;
  }


  while (true) {
   difference = node.getParticip().getHeight() - element;
   if (difference >= value) {
    if (selected == null) {
     selected = node;
    }
    if (Math.abs(10 - difference) == Math.abs(10 - Math.abs(selected.getParticip().getHeight() - element))) {
     if (selected.getParticip().getHeight() > node.getParticip().getHeight()) {
      selected = node;
     }
    }
    if (Math.abs(10 - difference) < best_match_distance) {
     best_match_distance = Math.abs(10 - difference);
     selected = node;
    }
   }

   if (difference >= 10) {
    if (node.getLeft() != null) {
     node = node.getLeft();
    } else {
     return selected;
    }
   } else {
    if (node.getRight() != null) {
     node = node.getRight();
    } else {
     return selected;
    }
   }
  }
 }


 public Node findSmaller(double value, double element) {
  Node selected = null;
  Node node = root;
  double difference;
  double best_match_distance = 15;


  if (root == null) {
   return null;
  }

  while (true) {

   difference = element - node.getParticip().getHeight();
   if (difference <= value) {
    if (selected == null) {
     selected = node;
    }
    if (Math.abs(10 - difference) == Math.abs(10 - Math.abs(selected.getParticip().getHeight() - element))) {
     if (selected.getParticip().getHeight() > node.getParticip().getHeight()) {
      selected = node;
     }
    }
    if (Math.abs(10 - difference) < best_match_distance) {
     best_match_distance = Math.abs(10 - difference);
     selected = node;
    }
   }
   if (difference >= 10) {
    if (node.getRight() != null) {
     node = node.getRight();
    } else {
     return selected;
    }
   } else {
    if (node.getLeft() != null) {
     node = node.getLeft();
    } else {
     return selected;
    }
   }
  }
 }




 public void shift(Node u, Node v) {
  if (u.getParent() == null) {
   root = v;
  } else if (u == u.getParent().getLeft()) {
   u.getParent().setLeft(v);
  } else {
   u.getParent().setRight(v);
  }
  if (v != null) {
   v.setParent(u.getParent());
  }
 }

 public void insert(Node node) {
  Node parent = null;
  Node current = root;
  while (current != null) {
   parent = current;
   if (node.getParticip().getHeight() < current.getParticip().getHeight()) {
    current = current.getLeft();
   } else {
    current = current.getRight();
   }
  }
  node.setParent(parent);
  if (parent == null) {
   root = node;
  } else if (node.getParticip().getHeight() < parent.getParticip().getHeight()) {
   parent.setLeft(node);
  } else {
   parent.setRight(node);
  }
 }

 public void delete(Node node) {
  if (node.getLeft() == null) {
   shift(node, node.getRight());
  } else if (node.getRight() == null) {
   shift(node, node.getLeft());
  } else {
   Node y = getSuccessor(node);
   if (y.getParent() != node) {
    shift(y, y.getRight());
    y.setRight(node.getRight());
    y.getRight().setParent(y);
   }
   shift(node, y);
   y.setLeft(node.getLeft());
   y.getLeft().setParent(y);
  }
 }

 public void inOrderTraverse(Node node, List<RacingParticipant> racParticipants) {
  if (node != null) {
   inOrderTraverse(node.getLeft(), racParticipants);
   racParticipants.add(node.getParticip());
   inOrderTraverse(node.getRight(), racParticipants);
  }
 }

 public Node getRoot() {
  return root;


 }
}






