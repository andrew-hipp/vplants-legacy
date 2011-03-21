package org.vplants.testing;
import java.util.Iterator;
import java.util.List;
import org.vplants.datahandler.DataBean;
import org.vplants.utils.XMLSupportBean;
import org.vplants.utils.jaxb.*;

public class tester 
{
  public tester()
  {
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    tester tester = new tester();
    tester.runTest();
  }
  
  public void runTest()
  {
    DataBean db = new DataBean();
    db.setGid("GEANA");
    XMLSupportBean bean = db.getXmlBean();
    
    SpeciesPage page = bean.getPageData();
    System.out.println("Name Code: "+ page.getNameCd());
    
    DescType desc = page.getDesc();
    System.out.println("Description: "+desc.getGrowthForm()+", "+desc.getSize());
    
    PartsType parts = desc.getParts();
    List partsList = parts.getPart();
    
    Iterator I = partsList.iterator();
    while (I.hasNext())
    {
      Part tempPt = (Part)(I.next());
      System.out.println(tempPt.getPartName()+": "+tempPt.getPartText());
    }
    
    
    
  }
  
}