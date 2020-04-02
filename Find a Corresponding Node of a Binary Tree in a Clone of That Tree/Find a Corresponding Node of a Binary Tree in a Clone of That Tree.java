import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
  String path = "";

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    return fetchTargetOnClone(cloned, getPath(original, target, "5"));
    /*
    // Traverse Original && Record path to target node BFS
    traverseDown(original.left, target, "0");
    traverseDown(original.right, target, "1");
    // Duplicate path order on cloned tree
    return fetchTargetOnClone(cloned, this.path);*/
  }

  private String getPath(final TreeNode input, final TreeNode target, String binary) {
    path += binary;
    TreeNode temp = new TreeNode(0);

    if (input.equals(target)) {
      return path;
    } else {
      if (temp.val != 0) {
        temp = traverseDown(input.left, target, "0");
      }
      if (temp.val != 0) {
        temp = traverseDown(input.right, target, "1");
      }
    }
    return path;
  }

  private final TreeNode traverseDown(final TreeNode input, final TreeNode target, String binary) {
    path += binary;
    TreeNode temp = new TreeNode(0);

    if (input.equals(target)) {
      return target;
    } else {
      if (temp.val != 0) {
        temp = traverseDown(input.left, target, "0");
      }
      if (temp.val != 0) {
        temp = traverseDown(input.right, target, "1");
      }
    }
    return temp;
  }

  private final TreeNode fetchTargetOnClone(final TreeNode cloned, String path) {
    char[] pathChars = path.toCharArray();
    return treeNodeFetcher(cloned, pathChars, 0);
  }

  private final TreeNode treeNodeFetcher(final TreeNode input, char[] pathChars, int pos) {
    pos++;
    TreeNode temp = new TreeNode(0);
    for (int i = pos; i < pathChars.length; i++) {
      if (pathChars[i] == '5') {
        break;
      } else if (pathChars[i] == '0') {
        temp = treeNodeFetcher(input.left, pathChars, pos);
      } else if (pathChars[i] == '1') {
        temp = treeNodeFetcher(input.right, pathChars, pos);
      }
    }
    return temp;
  }
}