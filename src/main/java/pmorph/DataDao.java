//package pmorph;
//
//import com.mongodb.WriteConcern;
//import dev.morphia.Datastore;
//import dev.morphia.query.Query;
//import org.bson.types.ObjectId;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.util.Collection;
//import java.util.List;
//
//public abstract class DataDao<T> {
//    @Resource
//    //protected MorphiaOrm morphiaOrm;
//    protected Class<T> clazz;
//    protected Datastore datastore;
//
//    public DataDao(Class<T> clazz, MorphiaOrm orm) {
//        this.clazz = clazz;
//        this.morphiaOrm = orm;
//        this.mapClasses();
//    }
//
//    @PostConstruct
//    public void mapClasses() {
//       // this.morphiaOrm.mapClass(this.clazz);
//        this.datastore = this.morphiaOrm.getDatastore();
//    }
//
//    public T find(ObjectId id) throws DatabaseException {
//        T t = (Data)this.datastore.find(this.clazz, "_id", id).get();
//        if (t == null) {
//            throw new DatabaseException(this.clazz.getName() + " ID not found:" + id);
//        } else {
//            return t;
//        }
//    }
//
//    public List<T> findByCriterion(String field, Object val) {
//        return ((Query)this.datastore.find(this.clazz).field(field).equal(val)).asList();
//    }
//
//    public List<T> findAll(Collection<ObjectId> ids) {
//        ((Query)this.datastore.find(this.clazz).field("_id").in(ids)).asList();
//    }
//
//    public ObjectId save(T obj) {
//        if (obj != null) {
//            this.datastore.save(obj, WriteConcern.SAFE);
//            return obj.getId();
//        } else {
//            return null;
//        }
//    }
//
//    public void saveAll(Collection<T> objs) {
//        this.datastore.save(objs, WriteConcern.SAFE);
//    }
//
//    public void delete(ObjectId id) {
//        Query<T> query = this.datastore.createQuery(this.clazz);
//        query.field("_id").equal(id);
//        this.datastore.delete(query, WriteConcern.SAFE);
//    }
//
//    public int deleteAllByObjId(Collection<ObjectId> ids) {
//        Query<T> query = this.datastore.createQuery(this.clazz);
//        query.field("_id").in(ids);
//        return this.datastore.delete(query, WriteConcern.SAFE).getN();
//    }
//
//    public int deleteByCriterion(String field, Object val) {
//        Query<T> query = this.datastore.createQuery(this.clazz);
//        query.field(field).equal(val);
//        return this.datastore.delete(query, WriteConcern.SAFE).getN();
//    }
//}

//
//public class NewsItemLayer extends DataDao<NewsItem> {
//    //Implement methods that you require
//    // Use this layer in the Application.java class
//}