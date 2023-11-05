package yuyu.infr.file;

import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.db.typesafe.ExDBTable;
import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.file.description.excel.annotations.Head;

@Head(labelless = false, sheet = "TestEntity", borderless = false)
public class TestEntity extends AbstractExDBEntity<TestEntity, TestEntityPk> {
    private static final long serialVersionUID = 1L;

    @Column(label = "name", order = 1)
    private String name;

    @Column(label = "age", order = 2)
    private String age;

    private TestEntityPk pk = new TestEntityPk();

    @Override
    public TestEntityPk getPrimaryKey() {
        return pk;
    }

    @Override
    public Class<? extends ExDBTable<TestEntity>> getMetaClass() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}

class TestEntityPk extends AbstractExDBPrimaryKey<TestEntity, TestEntityPk> {
    private static final long serialVersionUID = 1L;

    @Override
    public Class<TestEntity> getEntityClass() {
        return TestEntity.class;
    }

    @Override
    public int compareTo(TestEntityPk o) {
        return 1;
    }

}
