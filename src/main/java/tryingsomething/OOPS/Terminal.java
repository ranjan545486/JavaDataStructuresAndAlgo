package tryingsomething.OOPS;

/**
 * Created by rmukherj on 10/6/16.
 */
public class Terminal {
//    private class WaitingRunwayRequestor {
//        public IRunwayRequestor runwayRequestor;
//        public int minLength;
//    }
//
//    public List<Runway> AvailableRunways
//
//    {
//        get;
//        set;
//    }
//
//    public List<WaitingRunwayRequestor> WaitingRunwayRequestors
//
//    {
//        get;
//        set;
//    }
//
//    public Terminal() {
//        AvailableRunways = new List<Runway>();
//        WaitingRunwayRequestors = new List<WaitingRunwayRequestor>();
//    }
//
//    public void RequestRunway(IRunwayRequestor runwayRequestor, int minLength) {
//        Runway allocatedRunway = null;
//
//        foreach(Runway runway in AvailableRunways)
//        {
//            if (runway.length >= minLength) {
//                allocatedRunway = runway;
//                runwayRequestor.AssignRunway(runway);
//            }
//        }
//
//        if (allocatedRunway != null) {
//            AvailableRunways.Remove(allocatedRunway);
//        } else {
//            WaitingRunwayRequestors.Add(new WaitingRunwayRequestor() {
//                runwayRequestor =runwayRequestor,minLength =minLength
//            });
//        }
//    }
//
//    public void ReturnRunway(Runway runway) {
//        WaitingRunwayRequestor allocatedRunwayRequestor = null;
//
//        foreach(WaitingRunwayRequestor waitingRunwayRequestor in WaitingRunwayRequestors)
//        {
//            if (waitingRunwayRequestor.minLength <= runway.length) {
//                allocatedRunwayRequestor = waitingRunwayRequestor;
//                waitingRunwayRequestor.runwayRequestor.AssignRunway(runway);
//            }
//        }
//        if (allocatedRunwayRequestor != null) {
//            WaitingRunwayRequestors.Remove(allocatedRunwayRequestor);
//        } else {
//            AvailableRunways.Add(runway);
//        }
//    }
//
//}
//
//public class Runway {
//    public readonly
//    int length;
//    public readonly Terminal
//    terminal;//same runway cannot be at 2 terminals
//
//    public Runway(Terminal terminal, int length) {
//        this.terminal = terminal;
//        this.length = length;
//    }
//}
//
//public interface IRunwayRequestor {
//    void AssignRunway(Runway runway);
//
//    void ReturnRunway();
//}
//
//public abstract class RunwayRequestor {
//    public Runway AssignedRunway
//
//    {
//        get;
//        set;
//    }
//
//    public Terminal Terminal
//
//    {
//        get;
//        set;
//    }
//
//    public virtual
//
//    void AssignRunway(Runway runway) {
//        this.AssignedRunway = runway;
//    }
//
//    public virtual
//
//    void ReturnRunway() {
//        Terminal.ReturnRunway(AssignedRunway);
//        AssignedRunway = null;
//    }
//}
//
//public class Aircraft :RunwayRequestor
//        {
//public Aircraft(Terminal terminal)
//        {
//        this.Terminal=terminal;
//        }
//
//public override void AssignRunway(Runway runway)
//        {
//        base.AssignRunway(runway);
//        Land();
//        }
//public void Land()
//        {
//        //perform takeoff
//
//        ReturnRunway();
//        }
//        }
//
//public class MaintenanceCrew :RunwayRequestor
//        {
//public MaintenanceCrew(Terminal terminal)
//        {
//        this.Terminal=terminal;
//        }
//
//public override void AssignRunway(Runway runway)
//        {
//        base.AssignRunway(runway);
//        PerformMantenance();
//        }
//public void PerformMantenance()
//        {
//        //perform maintenance
//
//        ReturnRunway();
//        }

        }
