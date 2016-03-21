/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Maps 
// 0 = vacio
// 1 = bloqueo
// 2 = objeto
// P1 = personaje
// 5 = puerta salida casa
// 4 = puerta entrada mapa

var mapa1 = [[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,4,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"P1",1],
             [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]];
         
var casa  = [[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
             [1,1,1,1,1,1,1,1,1,"P1",1,1,1,1,1,1,1,1,1,1],
             [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]];         
 //
//Localización         
//1 = mapa1
//2= casa
var localizacion = 1;
var stage;
var circle;
var personaje;
var positionXP;
var positionYP;

var soundError = "error";

function loadSounds () {
  createjs.Sound.registerSound("http://localhost:8080/ProyectoTesis/recursos/sounds/error.mp3", soundError);
}



$(document).keydown(function(e) {
    
    if(e.keyCode > 36 && e.keyCode < 41) {
        if(localizacion===1){
           moverPersonaje(e,mapa1);
       }else if(localizacion===2){
           moverPersonaje(e,casa);
       }
       
    }else if(e.keyCode===32){
       if(localizacion===1){
          comprobar(mapa1);
       }else if(localizacion===2){
          comprobar(casa);
       }
    }
});

function comprobar(escenario){
    //console.log(escenario[positionXP][positionYP]);
    if(escenario[positionXP][positionYP]===4){
        localizacion = 2;
        pintarMundo(casa);
        resize(casa[0].length*50,casa.length*50);  
    }else if(escenario[positionXP][positionYP]===5){
        localizacion = 1;
        pintarMundo(mapa1);
        resize(mapa1[0].length*50,mapa1.length*50);  
        
    }
}

function moverPersonaje(position,escenario){
    if(position.keyCode===38){
         if(escenario[positionXP-1][positionYP]!==null && escenario[positionXP-1][positionYP]!==1){
             positionXP-=1;
            personaje.y -= 50;
         
        }else{
            
            createjs.Sound.play(soundError);
        }
       
      
     }else if(position.keyCode===40){
        if(escenario[positionXP+1][positionYP]!==null && escenario[positionXP+1][positionYP]!==1){
            positionXP+=1;
            personaje.y += 50;
        }else{
            
            createjs.Sound.play(soundError);
        } 
        
     }else if(position.keyCode===37){       
         if(escenario[positionXP][positionYP-1]!==null && escenario[positionXP][positionYP-1]!==1){
            positionYP-=1;
            personaje.x -= 50;
         }else{
            
            createjs.Sound.play(soundError);
        } 
         
     }else if(position.keyCode===39){
         if(escenario[positionXP][positionYP+1]!==null && escenario[positionXP][positionYP+1]!==1){
            positionYP+=1;
            personaje.x += 50;
         }else{
            
            createjs.Sound.play(soundError);
        }
     }
     
     console.log("x : " + positionXP + " y : " + positionYP );
     
     stage.update();
}

function resize(x,y) { 
   stage.canvas.width = x;
   stage.canvas.height = y;
   stage.update();
}


function init() {
    
    loadSounds ();
    stage = new createjs.Stage("mundoJuego");
   
    pintarMundo(mapa1);
   
    
}

function pintarMundo(escenario){
   
    stage.removeAllChildren();
    personaje = new createjs.Shape();
    var lineas = new Array(100);
    var x = 0;
    var y = 0;
    var newX = 1000;
    var newY = 0;
  
    
    var objetos  = new Array(500);;
    var contador = 0;
    
    var alto = escenario.length;
    var ancho = escenario[0].length;
    for (var i =0; i<alto;i++){
        for (var j =0 ;j<ancho;j++){
            objetos[contador] = new createjs.Shape();
                if(escenario[i][j]===1){
                    objetos[contador].graphics.beginFill("#CCFFCC").drawRect(j*50, i*50, 50, 50);
                    
                }else if(escenario[i][j]===0){
                    objetos[contador].graphics.beginFill("#FFE5CC").drawRect(j*50, i*50, 50, 50);
                    
                }else if(escenario[i][j]==="P1"){
                    objetos[contador].graphics.beginFill("#ffffff").drawRect(j*50, i*50, 50, 50);
                    positionXP = i;
                    positionYP = j;
                    personaje.graphics.beginFill("#ff0000").drawRect(j*50, i*50, 50, 50);
                }else if(escenario[i][j]===4){
                    objetos[contador].graphics.beginFill("#000000").drawRect(j*50, i*50, 50, 50);
                }
                else{
                    objetos[contador].graphics.beginFill("#000000").drawRect(j*50, i*50, 50, 50);
                } 
                stage.addChild(objetos[contador]);
                contador++;
                 
                 
        }
    }
    
      for (var i = 0;i<100;i++){
        lineas[i] = new createjs.Shape();
        lineas[i].graphics.setStrokeStyle(1).beginStroke("rgba(0,0,0,1)");
        if(i>49){
            if(i===50){
                newX=0;
            }
            y = 0;
            newY =1000;
            lineas[i].graphics.moveTo(x, y);
            lineas[i].graphics.lineTo(newX, newY);
            x += 50;
            newX += 50;
        }else{
            lineas[i].graphics.moveTo(x, y);
            lineas[i].graphics.lineTo(newX, newY);
            y+=50;
            newY+=50;
        }
        lineas[i].graphics.endStroke();
        stage.addChild(lineas[i]);
    }
    

    
    stage.addChild(personaje);
    stage.update();
    
    
}


