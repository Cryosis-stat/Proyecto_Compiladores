/*
 * @(#)IdentificationTable.java                2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Declaration;
import java.util.*;

public final class IdentificationTable {

  private int level;
  private IdEntry latest;
  

  public IdentificationTable () {
    level = 0;
    latest = null; 

  }

  // Opens a new level in the identification table, 1 higher than the
  // current topmost level.

  public void openScope () {

    level ++;
  }

  // Closes the topmost level in the identification table, discarding
  // all entries belonging to that level.

  public void closeScope () {

    IdEntry entry, local;

    // Presumably, idTable.level > 0.
    entry = this.latest;
    while (entry.level == this.level) {
      local = entry;
      entry = local.previous;
    }
    this.level--;
    this.latest = entry;
  }

  // Makes a new entry in the identification table for the given identifier
  // and attribute. The new entry belongs to the current level.
  // duplicated is set to to true iff there is already an entry for the
  // same identifier at the current level.

  public void enter (String packageId,String id, Declaration attr) {
    if (packageId==("_main")||packageId==null){
    IdEntry entry = this.latest;
    boolean present = false, searching = true;

    // Check for duplicate entry ...
    while (searching) {
      if (entry == null || entry.level < this.level)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
       } else
       entry = entry.previous;
    }

    attr.duplicated = present;
    // Add new entry ...
    entry = new IdEntry("_main", id, attr, this.level, this.latest);
    this.latest = entry;
    } else{
    IdEntry entryPack = this.latest;
    IdEntry entry;
    boolean present = false, searching = true;
// Check for duplicate entry ...
    while (searching) {
      if (entryPack == null || entryPack.level < this.level)
        searching = false;
      else if (entryPack.packageId.equals(packageId)) {
        entry = entryPack;
        if (entry.id.equals(id)){
          present = true;
          searching = false;                  
        }        
       } else
       entryPack = entryPack.previous;
    }

    attr.duplicated = present;
    // Add new entry ...
    entry = new IdEntry(packageId, id, attr, 0, this.latest);
    this.latest = entry;        
    }
  }
  /*
  public void enterPackage(String packageId, String id, Declaration attr){
    IdEntry entryPack = this.latest;
    IdEntry entry;
    boolean present = false, searching = true;

    // Check for duplicate entry ...
    while (searching) {
      if (entryPack == null || entryPack.level < this.level)
        searching = false;
      else if (entryPack.packageId.equals(packageId)) {
        entry = entryPack;
        if (entry.id.equals(id)){
          present = true;
          searching = false;                  
        }        
       } else
       entryPack = entryPack.previous;
    }

    attr.duplicated = present;
    // Add new entry ...
    entry = new IdEntry(packageId, id, attr, 0, this.latest);
    this.latest = entry;
  
  }*/

  // Finds an entry for the given identifier in the identification table,
  // if any. If there are several entries for that identifier, finds the
  // entry at the highest level, in accordance with the scope rules.
  // Returns null iff no entry is found.
  // otherwise returns the attribute field of the entry found.

  public Declaration retrieve (String packageId,String id) {
      
      if(packageId==null){
         packageId=  ("_main");
      }
    IdEntry entry;
    Declaration attr = null;
    boolean present = false, searching = true;

    entry = this.latest;
    while (searching) {
      if (entry == null)
        searching = false;
      else if (entry.id.equals(id)&& entry.packageId.equals(packageId) ){                         
            present = true;
            searching = false;
            attr = entry.attr;

    }else
        entry = entry.previous;
      } 


    
    return attr;
  }
  
  public IdEntry getLatest(){
      return this.latest;
  }
  
  public void restarLevel(){
      this.latest.level--;
  }
  
  public void subirLevel(){
      this.latest.level++;
  }
  
  //Reemplaza el puntero antiguoPrev por el nuevoPrev
  public void setPrevious(IdEntry prev, IdEntry nuevoPrev){
      IdEntry entry = this.latest;
      while(entry.previous != prev){
          entry = entry.previous;          
      }
      entry.previous = nuevoPrev;
  }

  

}
