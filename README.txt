

############ TO DO 
- Basic colonist 
	- Make clickable X
	- Position to destination direction calculator 
	
	- Make list of orders
	- Make list of objects



alien moving around (moving image) 


- Drawing everything
	- Gets all objects and draws them


	
########### HOW TO ADD HANDLERS/PHYSICAL OBJECTS
** Put all handlers in a HandlerTracker ** 

1. Create the object.
2. Create a handler, and in HandlerTracker:
	- create a clause "HANDLERTYPE" add function 
	- create a clause "HANDLERTYPE" get function 
	- create a clause "HANDLERTYPE" remove function.
	
3. (currently) Add draw objects function in the handler, and 
add a call in function drawFrame in Frame.
4. (currently) Add an update objects in the handler and add a 
call in the function actionPerformed in Frame.
5. (future) Add handler in check collisions object.





