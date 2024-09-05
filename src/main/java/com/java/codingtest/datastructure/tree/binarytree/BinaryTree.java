package com.java.codingtest.datastructure.tree.binarytree;

import java.util.*;

public class BinaryTree {
    /**
     * BFS (너비 우선 탐색)
     *
     * 시간 복잡도 분석:
     * 이진 트리의 노드 n개에 대하여 다음의 작업이 수행된다.
     * (1) 노드를 큐에 추가
     * (2) 노드를 큐에서 꺼내기
     *
     * 큐에 노드를 추가하는 q.add(root)와 노드를 꺼내는 q.poll()은 즉 O(1)에 수행된다.
     * 모든 노드를 한 번씩 방문하므로, 반복문은 n번 실행됩니다.
     *
     * 결론:
     * 시간 복잡도는 O(n)
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        if (root == null) return visited;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            visited.add(currentNode.value);

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }

        return visited;
    }
}
