package language;

import java.util.*;

/**
 * 
 * 国际化类
 * 国际化类，定义系统支持的语言，以便显示到页面的下拉框中，以下类名，方法名、原型都是以下一样
 * 
 * @author  yuanshiyong
 * @version  [1, Aug 18, 2009]
 */
public class Locales 
{
    private Locale current;
    public void setCurrent(Locale cur)
    {
        //如果为空时，则默认为系统的语言
        if (cur == null)
        {
            cur = Locale.getDefault();
        }
        this.current = cur;
    }
    
    
    public Map<String, Locale> getLocales() 
    {
       Map<String, Locale> locales =new Hashtable<String, Locale>();
       
       /*
       ResourceBundle bundle = ResourceBundle.getBundle("messageResource", current);
       locales.put(bundle.getString("zhcn"), Locale.CHINA);
       locales.put(bundle.getString("usen"), Locale.US);
      */
       
       locales.put("中文", Locale.CHINA);
       locales.put("English", Locale.US);
       return locales;
   }
}
