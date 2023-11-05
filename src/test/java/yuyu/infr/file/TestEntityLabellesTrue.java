package yuyu.infr.file;

import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.db.typesafe.ExDBTable;
import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.file.description.excel.annotations.Head;

@Head(labelless = true, sheet = "TestEntity", borderless = false)
public class TestEntityLabellesTrue extends AbstractExDBEntity<TestEntityLabellesTrue, TestPk> {
    private static final long serialVersionUID = 1L;

    @Column(label = "name", order = 1)
    private String name;

    @Column(label = "age", order = 2)
    private String age;

    private TestPk pk = new TestPk();

    @Override
    public TestPk getPrimaryKey() {
        return pk;
    }

    @Override
    public Class<? extends ExDBTable<TestEntityLabellesTrue>> getMetaClass() {
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

class TestPk extends AbstractExDBPrimaryKey<TestEntityLabellesTrue, TestPk> {
    private static final long serialVersionUID = 1L;

    @Override
    public Class<TestEntityLabellesTrue> getEntityClass() {
        return TestEntityLabellesTrue.class;
    }

    @Override
    public int compareTo(TestPk o) {
        return 1;
    }

}
