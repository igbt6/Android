package com.app.uszko.sqllitetestapp.model;

abstract public class ModelBase {

   protected long mId;

   public long getId() {
      return mId;
   }

   public void setId(long id) {
      mId = id;
   }

   @Override
   public String toString() {
      return "ModelBase [mId=" + mId + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + (int) (mId ^ (mId >>> 32));
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof ModelBase)) {
         return false;
      }
      ModelBase other = (ModelBase) obj;
      if (this.mId != other.mId) {
         return false;
      }
      return true;
   }

}
