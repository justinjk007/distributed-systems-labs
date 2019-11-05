package kaipada.Lamport;

public class VectorClock {
   int[] v;
   int myId;
   int N;
   
   public VectorClock(int numProc, int id) {
      myId = id;
      N = numProc;
      v = new int[numProc];
      for (int i = 0; i < N; i++) {
         v[i] = 0;
      }
      v[myId] = 1;
   }
     
   public void localStep() {
        v[myId]++;
   }
   
   public void sendEvent() {
      v[myId]++;
   }
   
   public void receiveEvent(int[] sentValue) {
      for (int i = 0; i < N; i++) {
         v[i] = max(v[i], sentValue[i]);
      }
      v[myId]++;
   }
   
   public int getValue(int i) {
      return v[i];
   }

    public int[] getVector() {
	return v;
    }
   
   public int max(int a, int b) {
      if(a>b) {
         return a;
      } else {
         return b;
      }
   }

   public String toString(){
      StringBuffer s = new StringBuffer();
      for (int j = 0; j < v.length; j++) {
         s.append(String.valueOf(v[j]) + " ");
      }
      return new String(s.toString());
   }
}
   
