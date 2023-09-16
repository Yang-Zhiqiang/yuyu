package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenIW_KhHubiDetailWk;


/**
 * 契約保全不備詳細ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhHubiDetailWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhHubiDetailWk<br />
 * @see     PKIW_KhHubiDetailWk<br />
 * @see     QIW_KhHubiDetailWk<br />
 * @see     GenQIW_KhHubiDetailWk<br />
 */
@Entity
public class IW_KhHubiDetailWk extends GenIW_KhHubiDetailWk {

    private static final long serialVersionUID = 1L;

    public IW_KhHubiDetailWk() {
    }

    public IW_KhHubiDetailWk(String pKouteikanriid,Integer pRenno3keta) {
        super(pKouteikanriid,pRenno3keta);
    }



    private IW_KhHubiWk iW_KhHubiWk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IW_KhHubiDetailWk.KOUTEIKANRIID  , referencedColumnName=IW_KhHubiWk.KOUTEIKANRIID, insertable=false, updatable=false)
    })
    public IW_KhHubiWk getKhHubiWk() {
        return iW_KhHubiWk;
    }

    public void setKhHubiWk(IW_KhHubiWk pIW_KhHubiWk) {
        this.iW_KhHubiWk = pIW_KhHubiWk;
    }

}

