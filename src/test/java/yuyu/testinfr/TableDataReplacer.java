package yuyu.testinfr;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;
import jp.co.slcs.swak.db.typesafe.ExDBTable;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import yuyu.def.db.mapping.AbstractExDBEntity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * DBテーブルデータのバックアップ・リストアに使うクラスです。
 */
public class TableDataReplacer {

    @Inject
    protected ExDBEntityManager em;

    @SuppressWarnings("rawtypes")
    private List<List<AbstractExDBEntity>> targetList = Lists.newArrayList();

    @SuppressWarnings("rawtypes")
    private List<Class<AbstractExDBEntity>> sizeZeros = Lists.newArrayList();

    private Logger logger = LoggerFactory.getLogger(TableDataReplacer.class);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    void tableDataReplace(List<Class<?>> backupTargets, List<List<AbstractExDBEntity>> entityLists){

        try{

            List<List<AbstractExDBEntity>> backupTargetDatas = Lists.newArrayList();

            if(backupTargets != null){
                for(Class clazz : backupTargets){

                    List<AbstractExDBEntity> backupTargetData = em.findAll(clazz);

                    backupTargetDatas.add(BeanUtil.createList(clazz, backupTargetData));

                    backupDelete(clazz, false);
                }
            }

            List<List<AbstractExDBEntity>> persistsList = Lists.newArrayList();

            for(List<AbstractExDBEntity> entities : entityLists){

                if(entities != null && entities.size() > 0){

                    Class<AbstractExDBEntity> entityClass = (Class<AbstractExDBEntity>)entities.get(0).getClass();

                    backupDelete(entityClass, false);

//                    List<AbstractExDBEntity> dbentitys = em.findAll(entityClass);
//                    dbentitys.addAll(entities);
                    persistsList.add(entities);
                }
            }

            em.flush();
            backupTargetDatas.addAll(persistsList);

            for(List<AbstractExDBEntity> dbentitys : backupTargetDatas){
                em.persist(dbentitys);
            }

            em.flush();
            em.getTransaction().commit();
            em.getTransaction().begin();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    void tableDataRestore(){

        if(em.getTransaction().isActive()){

            em.clear();
            em.getTransaction().rollback();
        }

        em.getTransaction().begin();

        try{

            for(Class<AbstractExDBEntity> clazz : sizeZeros){

                List<AbstractExDBEntity> dbentitys = em.findAll(clazz);

                ExDBTable table = (ExDBTable)clazz.newInstance().getMetaClass().newInstance();

                try{
//                    em.createJPQL($DELETE_FROM + table.getTable()).executeUpdate();
                    em.remove(dbentitys);
                    em.flush();
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }
                catch(Exception e){

                    logger.warn("◆" + table.getTable() + "(" + table.getAlias() + ") のリストアに失敗したため、無視します。");
                }
            }

            Collections.reverse(targetList);

            for(List<AbstractExDBEntity> entitys : targetList){

                String className = entitys.get(0).getClass().getName();

                if(className.indexOf("_$$_") > 0){
                    className = className.substring(0, className.indexOf("_$$_"));

                    entitys = (List<AbstractExDBEntity>) BeanUtil.createList(Class.forName(className), entitys);
                }

                Class clazz = Class.forName(className);

                List<AbstractExDBEntity> dbentitys = em.findAll(clazz);

                ExDBTable table = (ExDBTable)entitys.get(0).getMetaClass().newInstance();


                try{
//                    em.createJPQL($DELETE_FROM + table.getTable()).executeUpdate();

                    // dbentitys：マネージドの削除したいデータ
                    // entitys  ：アンマネージドの復旧したいデータ

                    Map<ExDBPrimaryKey<?, ?>, Integer> map = Maps.newHashMap();
                    int i = 0;
                    for(AbstractExDBEntity entity : dbentitys){

                        map.put(entity.getPrimaryKey(), i);
                        i++;
                    }

                    Set<ExDBPrimaryKey<?, ?>> matchingSet = Sets.newHashSet();
                    for(int j=0; j<entitys.size(); j++){

                        AbstractExDBEntity entity = entitys.get(j);

                        if(map.containsKey(entity.getPrimaryKey())){

                            int index = map.get(entity.getPrimaryKey());
                            AbstractExDBEntity managedEntity = dbentitys.get(index);
                            BeanUtil.copyProperties(managedEntity, entity);
                            matchingSet.add(entity.getPrimaryKey());
                            entitys.remove(j);
                            j--;
                        }
                    }

                    if(matchingSet.size()>0){
                        for(int j = 0; j < dbentitys.size(); j++){

                            AbstractExDBEntity dbentity = dbentitys.get(j);

                            if(matchingSet.contains(dbentity.getPrimaryKey())){
                                em.merge(dbentity);
                            }
                            else{
                                em.remove(dbentity);
                            }
                        }
                    }
                    else{
                        em.remove(dbentitys);
                    }

//                    em.remove(dbentitys);
                    em.flush();
                    em.getTransaction().commit();
                    em.getTransaction().begin();

                    em.persist(entitys);
                    em.flush();
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }
                catch(Exception e){

                    logger.warn("◆" + table.getTable() + "(" + table.getAlias() + ") のリストアに失敗したため、無視します。");
                    logger.warn(e.getMessage());
                    e.printStackTrace();
                    em.clear();
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                }
            }

        }catch(EntityNotFoundException e){

            logger.error("子テストデータに紐づく親テストデータが見つからないなど、テストデータ不整合の為、リストアに失敗しました。");
            e.printStackTrace();
            throw new RuntimeException(e);

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Transactional
    void backupDelete(Class<AbstractExDBEntity> clazz, boolean pCommitFlg){

        try{

            List<AbstractExDBEntity> dbentitys = em.findAll(clazz);

            if (dbentitys.size() > 0) {

                targetList.add((List<AbstractExDBEntity>) BeanUtil.createList(dbentitys.get(0).getClass(), dbentitys));


//                ■下記よりも深刻な問題が発生。エンティティ方式に戻す。 -- 2013.05.23
//                  エンティティでの操作とJPQLでの操作が別セッションになるため、相互の操作が干渉しあって競合エラーになる。
//
//                ■Cascade問題が解消するまでは、仕方ないのでJPQL方式に戻す。-- 2013.05.16
//                ・親エンティティの削除時に子エンティティもCascadeで削除されてしまう。
//                　一方リストア時、退避した親と子の関係がLAZYなので、子データを持っていない。よって子情報が紛失する。
//
//                ExDBTable table = (ExDBTable)dbentitys.get(0).getMetaClass().newInstance();
//                em.createJPQL($DELETE_FROM + table.getTable()).executeUpdate();

                em.remove(dbentitys); // ↑そもそも、JPA メソッドと JPQL を混ぜて使おうとしてる時点で何か違ってる...

                if(pCommitFlg){
                    em.flush();
//                    em.getTransaction().commit();
//                    em.getTransaction().begin();
                }
            }
            else{
                sizeZeros.add(clazz);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
