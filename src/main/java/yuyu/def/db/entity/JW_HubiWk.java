package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenJW_HubiWk;

import com.google.common.collect.Lists;


/**
 * 支払不備ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJW_HubiWk} の JavaDoc を参照してください。<br />
 * @see     GenJW_HubiWk<br />
 * @see     PKJW_HubiWk<br />
 * @see     QJW_HubiWk<br />
 * @see     GenQJW_HubiWk<br />
 */
@Entity
public class JW_HubiWk extends GenJW_HubiWk {

    private static final long serialVersionUID = 1L;

    public JW_HubiWk() {
    }

    public JW_HubiWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



    private List<JW_HubiDetailWk> jW_HubiDetailWks = Lists.newLinkedList();
    public JW_HubiDetailWk createHubiDetailWk() {
        JW_HubiDetailWk hubiDetailWk =  new JW_HubiDetailWk();
        hubiDetailWk.setHubiWk(this);
        hubiDetailWk.setKouteikanriid(this.getKouteikanriid());
        getHubiDetailWks().add(hubiDetailWk);
        return hubiDetailWk;
    }
    public void setHubiDetailWks(List<JW_HubiDetailWk> pJW_HubiDetailWks) {
        this.jW_HubiDetailWks = pJW_HubiDetailWks;
    }
    @OneToMany (
        mappedBy = "hubiWk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(JW_HubiDetailWk.KOUTEIKANRIID+" ASC ,"+JW_HubiDetailWk.RENNO3KETA+" ASC ")
    public  List<JW_HubiDetailWk> getHubiDetailWks() {
        return jW_HubiDetailWks;
    }

}

