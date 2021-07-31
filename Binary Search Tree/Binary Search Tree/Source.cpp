#include <iostream>
using namespace std;

// node
struct Node {
    char label;
    Node* left, * right, * parent;
};

// variabel pointer global
Node* root, * newNode;

// create New Tree
void createNewTree(char label) {
    if (root != NULL)
        cout << "\nTree sudah dibuat" << endl;
    else {
        root = new Node();
        root->label = label;
        root->left = NULL;
        root->right = NULL;
        root->parent = NULL;
        cout << "\nNode " << label << " berhasil dibuat menjadi root." << endl;
    }
}

// insert Left
Node* insertLeft(char label, Node* node) {
    if (root == NULL) {
        cout << "\nBuat tree terlebih dahulu!!" << endl;
        return NULL;
    }
    else {
        // cek apakah anak kiri ada atau tidak
        if (node->left != NULL) {
            // kalau ada
            cout << "\nNode " << node->label << " sudah ada anak kiri!!" << endl;
            return NULL;
        }
        else {
            // kalau tidak ada
            newNode = new Node();
            newNode->label = label;
            newNode->left = NULL;
            newNode->right = NULL;
            newNode->parent = node;
            node->left = newNode;
            cout << "\nNode " << label << " berhasil ditambahkan ke anak kiri " << newNode->parent->label << endl;
            return newNode;
        }
    }
}

// insert right
Node* insertRight(char label, Node* node) {
    if (root == NULL) {
        cout << "\nBuat tree terlebih dahulu!!" << endl;
        return NULL;
    }
    else {
        // cek apakah anak kiri ada atau tidak
        if (node->right != NULL) {
            // kalau ada
            cout << "\nNode " << node->label << " sudah ada anak kanan!!" << endl;
            return NULL;
        }
        else {
            // kalau tidak ada
            newNode = new Node();
            newNode->label = label;
            newNode->left = NULL;
            newNode->right = NULL;
            newNode->parent = node;
            node->right = newNode;
            cout << "\nNode " << label << " berhasil ditambahkan ke anak kanan " << newNode->parent->label << endl;
            return newNode;
        }
    }
}

// Empty
bool empty() {
    if (root == NULL)
        return true;
    else
        return false;
}

// Tranversal
// preOrder
void preOrder(Node* node = root) {
    if (!root)
        cout << "\nBuat tree terlebih dahulu!!" << endl;
    else {

        if (node != NULL) {
            cout << node->label << ", ";
            preOrder(node->left);
            preOrder(node->right);
        }
    }
}

// inOrder
void inOrder(Node* node = root) {
    if (!root)
        cout << "\nBuat tree terlebih dahulu!!" << endl;
    else {

        if (node != NULL) {
            inOrder(node->left);
            cout << node->label << ", ";
            inOrder(node->right);
        }
    }
}

// postOrder
void postOrder(Node* node = root) {
    if (!root)
        cout << "\nBuat tree terlebih dahulu!!" << endl;
    else {

        if (node != NULL) {
            postOrder(node->left);
            postOrder(node->right);
            cout << node->label << ", ";
        }
    }
}


// size
int size(Node* node = root) {
    if (!root) {
        cout << "\nBuat tree terlebih dahulu!!" << endl;
        return 0;
    }
    else {
        if (!node) {
            return 0;
        }
        else {
            return 1 + size(node->left) + size(node->right);
        }
    }
}

// height
int height(Node* node = root) {
    if (!root) {
        cout << "\nBuat tree terlebih dahulu!!" << endl;
        return 0;
    }
    else {
        if (!node) {
            return 0;
        }
        else {
            int heightKiri = height(node->left);
            int heightKanan = height(node->right);

            if (heightKiri >= heightKanan) {
                return heightKiri + 1;
            }
            else {
                return heightKanan + 1;
            }

        }
    }
}

// characteristic
void charateristic()
{
    cout << "\nSize Tree : " << size() << endl;
    cout << "Height Tree : " << height() << endl;
    cout << "Average Node of Tree : " << size() / height() << endl;
}

int main()
{

    createNewTree('+');

    Node* nodeB, * nodeC, * nodeD, * nodeE, * nodeF, * nodeG, * nodeH, * nodeI, * nodeJ, * nodeK, * nodeL, * nodeM, * nodeN, * nodeO, * nodeP, * nodeQ, * nodeR, * nodeS;

    nodeB = insertLeft('A', root);
    nodeC = insertRight('*', root);
    nodeD = insertLeft('J', nodeC);
    nodeE = insertRight('-', nodeC);
    nodeF = insertLeft('*', nodeE);
    nodeG = insertRight('*', nodeE);
    nodeH = insertLeft('B', nodeF);
    nodeI = insertRight('C', nodeF);
    nodeJ = insertLeft('/', nodeG);
    nodeK = insertRight('-', nodeG);
    nodeL = insertLeft('+', nodeJ);
    nodeM = insertRight('-', nodeJ);
    nodeN = insertLeft('D', nodeL);
    nodeO = insertRight('E', nodeL);
    nodeP = insertLeft('F', nodeM);
    nodeQ = insertRight('G', nodeM);
    nodeR = insertLeft('H', nodeK);
    nodeS = insertRight('I', nodeK);


    cout << "\nPreOrder :" << endl;
    preOrder(root);
    cout << "\n" << endl;
    cout << "InOrder :" << endl;
    inOrder(root);
    cout << "\n" << endl;
    cout << "PostOrder :" << endl;
    postOrder(root);
    cout << "\n" << endl;

    charateristic();
}