package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_IjitoukeiMeisai;


/**
 * 医事統計明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_IjitoukeiMeisai} の JavaDoc を参照してください。<br />
 * @see     GenHT_IjitoukeiMeisai<br />
 * @see     PKHT_IjitoukeiMeisai<br />
 * @see     QHT_IjitoukeiMeisai<br />
 * @see     GenQHT_IjitoukeiMeisai<br />
 */
@Entity
public class HT_IjitoukeiMeisai extends GenHT_IjitoukeiMeisai {

    private static final long serialVersionUID = 1L;

    public HT_IjitoukeiMeisai() {
    }

    public HT_IjitoukeiMeisai(String pSyono,Integer pRenno8keta) {
        super(pSyono,pRenno8keta);
    }

    private HM_SiinBunrui hM_SiinBunrui ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_IjitoukeiMeisai.SIINCD  , referencedColumnName=HM_SiinBunrui.SIINCD, insertable=false, updatable=false)
    })
    public  HM_SiinBunrui getSiinBunrui() {
        return hM_SiinBunrui;
    }

    public void setSiinBunrui(HM_SiinBunrui pHM_SiinBunrui) {
        this.hM_SiinBunrui = pHM_SiinBunrui;
    }

}

