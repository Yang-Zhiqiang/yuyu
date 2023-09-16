package yuyu.def.db.mapping;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.EntityNotFoundException;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;

import org.hibernate.annotations.NotFound;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * 全てのテーブルマッピングBeanの親クラスです。<br />
 * 全テーブル固定の項目を提供します。
 * @param <E>  Entity クラス
 * @param <PK> PrimaryKey クラス
 */
@MappedSuperclass
public abstract class AbstractExDBEntity<E extends ExDBEntity<E, PK>, PK extends ExDBPrimaryKey<E, PK>>
extends jp.co.slcs.swak.db.typesafe.AbstractExDBEntity<E, PK> {

    private static final long serialVersionUID = 281L;

    public static final String KOUSINSYAID                   = "kousinsyaId";
    public static final String KOUSINTIME                    = "kousinTime";
    public static final String KOUSINKINOU                   = "kousinKinou";
    public static final String VERSION                       = "version";

    protected AbstractExDBEntity() {
        version = System.currentTimeMillis();
    }

    //    @Transient
    //    protected <C extends AbstractExDBEntity<C, ?>> List<C> readyChildEntityList(List<C> children) {
    //        if (children != null) {
    //            if (children.size() > 0) {
    //                Logger logger = LoggerFactory.getLogger(getClass());
    //                if (logger.isTraceEnabled()) {
    //                    logger.trace(
    //                        String.format(
    //                            "◇ [%s(%s)] の子要素 [%s] を %d 件取得しました。",
    //                            getClass().getSimpleName(),
    //                            getPrimaryKey(),
    //                            children.get(0).getClass().getSimpleName(),
    //                            Integer.valueOf(children.size())
    //                        )
    //                    );
    //                }
    //            }
    //            return children;
    //        }
    //
    //        if (loaded == false){
    //            return Lists.newLinkedList();
    //        }
    //
    //        throw new RuntimeException("エンティティクラスが想定外の状態（マネージドかつ子要素がNULL）の状態になりました。");
    //    }

    @PrePersist
    protected void prePersist() {
        setSystemProperties(false);
    }

    @PreUpdate
    protected void preUpdate() {
        setSystemProperties(true);
    }

    private void setSystemProperties(boolean forceUpdateKousinsyaId) {
        @Nullable Credentials credentials = SWAKInjector.getInstance(Credentials.class);
        if (forceUpdateKousinsyaId || Strings.isNullOrEmpty(getKousinsyaId())) {
            setKousinsyaId(
                Optional.fromNullable(credentials).transform(
                    new Function<Credentials, String>() {
                        @Override
                        public String apply(Credentials c) {
                            return Optional.fromNullable(c.getUsername()).or("_system_");
                        }
                    }
                    ).or("_system_")
                );
        }

        @Nullable AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        if (kinou == null) { setKousinKinou("_system_");         }
        else               { setKousinKinou(kinou.getKinouId()); }

        setKousinTime(BizDate.getSysDateTimeMilli());
    }

    private boolean loaded = false;

    @PostLoad
    private void setLoaded(){
        loaded = true;
    }

    @Transient
    public boolean isLoaded(){
        return loaded;
    }

    @PostUpdate
    private void commited(){
        loaded = false;
    }

    private boolean removed = false;

    @PostRemove
    private void setRemoved(){
        removed = true;
    }

    @Transient
    public boolean isRemoved(){
        return removed;
    }

    private String kousinsyaId;

    @Column(name="kousinsyaId")
    public String getKousinsyaId() {
        return kousinsyaId;
    }

    public void setKousinsyaId(String pKousinsyaId) {
        kousinsyaId = pKousinsyaId;
    }

    private String kousinTime;

    @Column(name="kousinTime")
    public String getKousinTime() {
        return kousinTime;
    }

    public void setKousinTime(String pKousinTime) {
        kousinTime = pKousinTime;
    }

    private String kousinKinou;

    @Column(name="kousinKinou")
    public String getKousinKinou() {
        return kousinKinou;
    }

    public void setKousinKinou(String pKousinKinou) {
        kousinKinou = pKousinKinou;
    }

    private long version;

    @Version
    @Column(name="version")
    public long getVersion() {
        return version;
    }

    public void setVersion(long pVersion) {
        version = pVersion;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void backup(String pTrkssikibetukey)throws Exception {
        try {
            ExDBEntity bakupEntity = createBackup(pTrkssikibetukey);
            SWAKInjector.getInstance(BaseDomManager.class).insert(bakupEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "rawtypes" })
    public ExDBEntity createBackup(String pTrkssikibetukey){
        Map<String,PropertyDescriptor> fromEntitysMap = getEntityPropertiesMap(this.getExcludeProps());
        for(Map.Entry<String, PropertyDescriptor> e:fromEntitysMap.entrySet()){
            if(e.getValue().getReadMethod().isAnnotationPresent(ManyToOne.class) && !e.getValue().getReadMethod().isAnnotationPresent(NotFound.class)){
                throw new RuntimeException("ルートエンティティからバックアップしてください。");
            }
        }
        try {
            return depthCopy(this, pTrkssikibetukey);
        } catch (Exception e) {
            throw new BizAppException(e,"バックアップ処理時エラーが発生しました。");
        }
    }

    @SuppressWarnings("rawtypes")
    public ExDBEntity createRestore() {
        Map<String,PropertyDescriptor> fromEntitysMap = getEntityPropertiesMap(this.getExcludeProps());
        for(Map.Entry<String, PropertyDescriptor> e:fromEntitysMap.entrySet()){
            if(e.getValue().getReadMethod().isAnnotationPresent(ManyToOne.class) && !e.getValue().getReadMethod().isAnnotationPresent(NotFound.class)){
                throw new RuntimeException("ルートエンティティからリストアしてください。");
            }
        }
        try {
            return depthCopy(this, null);
        } catch (Exception e) {
            throw new BizAppException(e,"リストア処理時エラーが発生しました。");
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static <F extends ExDBEntity<F, ?>, T extends ExDBEntity<T, ?>> ExDBEntity<T, ?> depthCopy(ExDBEntity<F, ?> fromEntity,String pTrkssikibetukey) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<F> fromClass = (Class<F>) fromEntity.getClass();
        String fromEntityName = fromClass.getName();
        String toEntityClassName = getToEntityName(fromEntityName);
        Class<T> toEntityClass = (Class<T>) Class.forName(toEntityClassName);
        ExDBEntity<T, ?> toEntity = toEntityClass.getConstructor().newInstance();
        Map<String,PropertyDescriptor> fromEntityPropertiesMap = getEntityPropertiesMap(fromEntity.getPersistProps());
        Map<String,PropertyDescriptor> toEntityPropertiesMap = getEntityPropertiesMap(toEntity.getPersistProps());

        for(Map.Entry<String, PropertyDescriptor> e:toEntityPropertiesMap.entrySet()){
            PropertyDescriptor fromProperty = fromEntityPropertiesMap.get(e.getKey());
            PropertyDescriptor toProperty = e.getValue();
            if(fromProperty != null){
                toProperty.getWriteMethod().invoke(toEntity, fromProperty.getReadMethod().invoke(fromEntity));
            }else{
                if(pTrkssikibetukey != null){
                    toProperty.getWriteMethod().invoke(toEntity, new Object[] { pTrkssikibetukey });
                }
            }
        }

        Map<String,PropertyDescriptor> fromSubEntitysMap = getEntityPropertiesMap(fromEntity.getExcludeProps());
        Map<String,PropertyDescriptor> toSubEntitysMap = getEntityPropertiesMap(toEntity.getExcludeProps());
        for(Map.Entry<String, PropertyDescriptor> e:toSubEntitysMap.entrySet()){
            PropertyDescriptor fromSubEntity = fromSubEntitysMap.get(getSubEntityName(e.getKey()));
            PropertyDescriptor toSubEntity = e.getValue();
            if(fromSubEntity != null && !fromSubEntity.getReadMethod().isAnnotationPresent(ManyToOne.class)){
                Object fromValue = fromSubEntity.getReadMethod().invoke(fromEntity);
                if(fromValue instanceof List){
                    List<ExDBEntity> subEntityList = (List<ExDBEntity>)fromValue;
                    List<ExDBEntity> newSubEntityList = new ArrayList<ExDBEntity>();
                    for(ExDBEntity entity:subEntityList){
                        ExDBEntity newEntity = depthCopy(entity,pTrkssikibetukey);
                        newSubEntityList.add(newEntity);
                    }
                    toSubEntity.getWriteMethod().invoke(toEntity,newSubEntityList);
                }else if(fromValue != null && fromValue instanceof ExDBEntity ){
                    ExDBEntity newEntity = depthCopy((ExDBEntity)fromValue,pTrkssikibetukey);
                    toSubEntity.getWriteMethod().invoke(toEntity, newEntity);
                }
            }
        }
        return toEntity;
    }

    private static Map<String,PropertyDescriptor> getEntityPropertiesMap(Iterable<PropertyDescriptor> properties) {
        Map<String,PropertyDescriptor> propertiesMap = new HashMap<String,PropertyDescriptor>();
        for (PropertyDescriptor property : properties) {
            propertiesMap.put(property.getName(), property);
        }
        return propertiesMap;
    }

    private static String getToEntityName(String fromEntityName) {
        String fixedStr = "_BAK";
        if (fromEntityName.indexOf(fixedStr) > 0) {
            return fromEntityName.replace(fixedStr, "");
        }
        return fromEntityName.replace("_", fixedStr+"_");
    }

    private static String getSubEntityName(String entityName) {
        if(entityName.indexOf("BAK") == 0){
            if(entityName.substring(4,5).equals(entityName.substring(4,5).toUpperCase())){
                return entityName.substring(3).substring(0,1).toUpperCase() + entityName.substring(4);
            }else{
                return entityName.substring(3).substring(0,1).toLowerCase() + entityName.substring(4);
            }
        }
        return "BAK" + entityName.substring(0,1).toUpperCase() + entityName.substring(1);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void detach(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        if(em.getEntityManager().contains(this)){
            em.detach((ExDBEntity)this);
            loaded = false;
        }
        else{
            throw new RuntimeException("This entity is not managed.");
        }
    }

    public void noCheckDetach() {
        SWAKInjector.getInstance(ExDBEntityManager.class).getEntityManager().detach(this);
    }

    public <F> void requiredEntities(List<F> list,Class<F> clz) {
        if (list == null || list.size() == 0) {
            String pkStr = this.getPrimaryKey().toString();
            pkStr = "yuyu.def.db.entity.$entity_name$ with id PK$entity_name$" + pkStr.substring(pkStr.indexOf("{"));
            pkStr=pkStr.replace("$entity_name$", clz.getName().replace("yuyu.def.db.entity.",""));
            throw new EntityNotFoundException("必要なエンティティが見つかりません。(" + pkStr +")");

        }
    }

}
