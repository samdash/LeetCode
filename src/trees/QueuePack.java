package trees;

//this class' represents the items stored in queue (used for level order
//traversal). Objects will store the nodes and its level
class QueuePack {
	int level;
	TreeNode tnode;

	public QueuePack(int level, TreeNode tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}