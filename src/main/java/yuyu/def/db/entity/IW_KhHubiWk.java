package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenIW_KhHubiWk;

import com.google.common.collect.Lists;


/**
 * 契約保全不備ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhHubiWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhHubiWk<br />
 * @see     PKIW_KhHubiWk<br />
 * @see     QIW_KhHubiWk<br />
 * @see     GenQIW_KhHubiWk<br />
 */
@Entity
public class IW_KhHubiWk extends GenIW_KhHubiWk {

    private static final long serialVersionUID = 1L;

    public IW_KhHubiWk() {
    }

    public IW_KhHubiWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



    private List<IW_KhHubiDetailWk> iW_KhHubiDetailWks = Lists.newLinkedList();
    public IW_KhHubiDetailWk createKhHubiDetailWk() {
        IW_KhHubiDetailWk khHubiDetailWk =  new IW_KhHubiDetailWk();
        khHubiDetailWk.setKhHubiWk(this);
        khHubiDetailWk.setKouteikanriid(this.getKouteikanriid());
        getKhHubiDetailWks().add(khHubiDetailWk);
        return khHubiDetailWk;
    }
    public void setKhHubiDetailWks(List<IW_KhHubiDetailWk> pIW_KhHubiDetailWks) {
        this.iW_KhHubiDetailWks = pIW_KhHubiDetailWks;
    }
    @OneToMany (
        mappedBy = "khHubiWk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(IW_KhHubiDetailWk.KOUTEIKANRIID+" ASC ,"+IW_KhHubiDetailWk.RENNO3KETA+" ASC ")
    public  List<IW_KhHubiDetailWk> getKhHubiDetailWks() {
        return iW_KhHubiDetailWks;
    }

}

