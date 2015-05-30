import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Created with IntelliJ IDEA.
 * User: norman
 * Date: 24.10.12
 * Time: 19:24
 * To change this template use File | Settings | File Templates.
 */
public class FirstHazelcast {
    public static void main(String[] args) {
        Config config = new ClasspathXmlConfig(ClassLoader.getSystemClassLoader(), "sample-config.xml");
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        IMap<Object, Object> map = hazelcastInstance.getMap("default");
        map.put("test", "hallo");
        System.out.println(map.getLocalMapStats().getBackupEntryMemoryCost());
        hazelcastInstance.shutdown();
    }
}
