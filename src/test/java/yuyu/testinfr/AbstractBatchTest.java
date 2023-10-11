package yuyu.testinfr;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBFactory;
import jp.co.slcs.swak.db.typesafe.ExDBField;
import jp.co.slcs.swak.db.typesafe.ExDBTable;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.description.ColumnDesc;
import jp.co.slcs.swak.file.description.HeadDesc;
import jp.co.slcs.swak.file.description.excel.ExcelColumnDesc;
import jp.co.slcs.swak.file.description.excel.ExcelHeadDesc;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.exception.CvtVdtException.Message;
import jp.co.slcs.swak.util.reflect.ClassUtils;
import lombok.val;
import yuyu.def.db.mapping.AbstractExDBEntity;

public class AbstractBatchTest {

    public void beforeCase() {
//        BatchScope.begin();
//        SWAKInjector.getInstance(Transaction.class).begin();
    }

    public void afterCase() {
//        SWAKInjector.getInstance(Transaction.class).end();
//        BatchScope.end();
    }

    @SuppressWarnings("unused")
    public void preTestCase(String caseName) {
    }

    @SuppressWarnings("unused")
    public void postTestCase(String caseName) {
    }

    protected <E> FileDescription<E, ExcelHeadDesc, ExcelColumnDesc> generateFileDescription(Class<E> entityClass) {
        ExcelHeadDesc chd = new ExcelHeadDesc();
        List<ExcelColumnDesc> ccdList = Lists.newArrayList();
        Class<?> metaClass = null;
        try {
            metaClass = ClassUtils.loadClass("yuyu.def.db.meta.GenQ" + entityClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Field[] fs = metaClass.getDeclaredFields();
        for (Field f : fs) {
            if (ExDBField.class.isAssignableFrom(f.getType())) {
                ExcelColumnDesc ccd = new ExcelColumnDesc(f.getName());
                ccd.setLabel(f.getName());
                ccdList.add(ccd);
            }
        }

        return new FileDescription<>(entityClass, chd, ccdList.toArray(new ExcelColumnDesc[ccdList.size()]));
    }

    @SuppressWarnings("rawtypes")
    protected void clearTable(Class<? extends AbstractExDBEntity> entityClass) {
        try (val em = SWAKInjector.getInstance(ExDBFactory.class).createExDBEntityManager()) {
            try {
                if (!em.getTransaction().isActive()) {
                    em.getTransaction().begin();
                }
                String tableId = ((ExDBTable) entityClass.newInstance().getMetaClass().newInstance()).getTable();
                em.createJPQL($DELETE_FROM + tableId).executeUpdate();
                em.flush();
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings({ "rawtypes" })
    protected <E extends AbstractExDBEntity> void initTable(String caseName, Class<E> entityClass) {
        FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.XLS);
        try {
            FileDescription<E, ? extends HeadDesc, ? extends ColumnDesc> fileDesc = fileEntityManager.parseDescription(entityClass, this.getClass().getResourceAsStream(caseName + ".xls"), entityClass.getSimpleName());
            List<E> entityList = fileEntityManager.read(fileDesc, this.getClass().getResourceAsStream(caseName + ".xls"));
            initTable(entityList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CvtVdtException e) {
            for (Message msg : e.getMessages()) {
                System.out.println(msg.getMessageType() + ": " + msg.getMessage());
            }
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void initTable(List<? extends AbstractExDBEntity> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return;
        }

        try (val em = SWAKInjector.getInstance(ExDBFactory.class).createExDBEntityManager()) {
            try {
                if (!em.getTransaction().isActive()) {
                    em.getTransaction().begin();
                }
                for (AbstractExDBEntity entity : entityList) {
                    em.persist(entity);
                }
                em.flush();
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
