import javax.xml.transform.Source;
public class node { //create the node
public int id, contact; //decalare the variables that need to store the entry data
public String name,email;
public node next;//declare the next of the node
node(int id, int contact, String name, String email){//constructor to get the data from param
//define the variables and assign data
this.id = id;
this.contact = contact;
this.name = name;
this.email = email;
}
}
class LinkedList{//create the linked list
private node head ; //declare the head of the list'
LinkedList(){ //constructor
head = null; // initially the head is null
}
//check whether the list is empty or not
public boolean isEmpty(){
return head == null; // if head is null the list is empty
}
//insert data to the list
public void insertData(int id, int contact, String name, String email){
node newNode = new node(id,contact,name,email); // create a new node and add data
if(isEmpty()){ //check whether the list is empty or not
head = newNode; //if empty the new node will be connected to the head
System.out.println("Data inserted!");
}
else{
String aname = name;// assign the name to new variable
char nameChar = aname.charAt(0);//get the first char of the name
node current = head; //create a new variable and assign it to head 4
node previous = null; //create a new variable to store previous node
while(current.name.charAt(0) != nameChar){ //find the node that match to the first char of the user input name
if(current.next == null){ // if the current is tail the while will be break
break;
}
previous = current; //assign the current node to previous
current = current.next; // assign next node to the current
}
if(current == head){ // if current = to head
newNode.next = head;// new node next should be head
head = newNode; // and the head connect to the new node
System.out.println("Data inserted3!");
}else if(current.next == null){ // if the current node is tail
current.next = newNode;// current node next be newNode
newNode.next = null; // new node will be tail
System.out.println("Data inserted2!");
}
else{ // otherwise new node next should be current node and the previous node next be new node
newNode.next = current;
previous.next = newNode;
System.out.println("Data inserted4!");
}
}
}
//find a contact
public int findContact(String name){
node current = head; //create variable and assign it to head
if(isEmpty()){
System.out.println("can not find the contact");
return 1; // list empty return 1
}else{

while(current.name != name){ // find the node that is equals to the entered name
if(current.next == null){
System.out.println("can not find the contact2");
return 1; // if the current node is tail return 1
}else{
current = current.next;//otherwise go to the next node to ckeck
}
}
return current.contact; // return the found node contact number
}
}
//delete a contact
public String deleteNode(String name){
node current = head; // create new variable and assign head
node previous = null; // creat new variable to store previous node
if(isEmpty()){
System.out.println("There is no any contact to delete!");
return null; // if list is empty it will return null
}else{
while(current.name != name ){ // find node that match to the etered name
if(current.next == null){
return null; //if the current nod is tail return null
}else{
previous = current; // store the previous nod
current = current.next; //go to the next node
}
}
if(current == head){// if matching node is head delete the head and assig next node to head
head = head.next;
}else{
previous.next = current.next; //otherwise previous node equals to current node
}
return current.name + "Deleted!"; // then return the deleted contact name
}
}

//display the all elements in the contact list
public void displayList(){
node current = head;
if(isEmpty()){
System.out.println("List is empty!");
}else{
while(current != null){
System.out.println(current.name);
current = current.next;
}
}
}
}