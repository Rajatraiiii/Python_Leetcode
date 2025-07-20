from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)

class Solution(object):
    def deleteDuplicateFolder(self, paths):
        """
        :type paths: List[List[str]]
        :rtype: List[List[str]]
        """
        root = TrieNode()

        # Step 1: Build the trie tree
        for path in paths:
            node = root
            for folder in path:
                node = node.children[folder]

        serial_map = defaultdict(list)
        duplicates = set()

        # Step 2: Serialize subtrees
        def serialize(node):
            if not node.children:
                return ""
            serials = []
            for name in sorted(node.children.keys()):
                sub_serial = serialize(node.children[name])
                serials.append("{}({})".format(name, sub_serial))  # changed here
            serial = "".join(serials)
            serial_map[serial].append(node)
            return serial

        serialize(root)

        # Step 3: Detect duplicate serialized subtrees
        for nodes in serial_map.values():
            if len(nodes) > 1:
                for node in nodes:
                    duplicates.add(node)

        result = []

        # Step 4: DFS to collect paths not marked as duplicate
        def dfs(node, path):
            if node in duplicates:
                return
            if path:
                result.append(path[:])
            for name, child in node.children.items():
                path.append(name)
                dfs(child, path)
                path.pop()

        dfs(root, [])
        return result
