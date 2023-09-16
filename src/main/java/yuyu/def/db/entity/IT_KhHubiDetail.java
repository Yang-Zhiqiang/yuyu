package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenIT_KhHubiDetail;


/**
 * 契約保全不備詳細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHubiDetail} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhHubiDetail<br />
 * @see     PKIT_KhHubiDetail<br />
 * @see     QIT_KhHubiDetail<br />
 * @see     GenQIT_KhHubiDetail<br />
 */
@Entity
public class IT_KhHubiDetail extends GenIT_KhHubiDetail {

    private static final long serialVersionUID = 1L;

    public IT_KhHubiDetail() {
    }

    public IT_KhHubiDetail(String pHubisikibetukey,Integer pRenno3keta) {
        super(pHubisikibetukey,pRenno3keta);
    }



    private IT_KhHubi iT_KhHubi ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhHubiDetail.HUBISIKIBETUKEY  , referencedColumnName=IT_KhHubi.HUBISIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhHubi getKhHubi() {
        return iT_KhHubi;
    }

    public void setKhHubi(IT_KhHubi pIT_KhHubi) {
        this.iT_KhHubi = pIT_KhHubi;
    }

    private AM_SyoruiZokusei aM_SyoruiZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_KhHubiDetail.HUBISYORUICD  , referencedColumnName=AM_SyoruiZokusei.SYORUICD, insertable=false, updatable=false),
    })
    public  AM_SyoruiZokusei getSyoruiZokusei() {
        return aM_SyoruiZokusei;
    }

    public void setSyoruiZokusei(AM_SyoruiZokusei pAM_SyoruiZokusei) {
        this.aM_SyoruiZokusei = pAM_SyoruiZokusei;
    }

}

