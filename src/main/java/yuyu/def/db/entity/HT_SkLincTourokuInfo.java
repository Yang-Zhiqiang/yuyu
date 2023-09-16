package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_SkLincTourokuInfo;


/**
 * 新契約ＬＩＮＣ登録情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkLincTourokuInfo} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkLincTourokuInfo<br />
 * @see     PKHT_SkLincTourokuInfo<br />
 * @see     QHT_SkLincTourokuInfo<br />
 * @see     GenQHT_SkLincTourokuInfo<br />
 */
@Entity
public class HT_SkLincTourokuInfo extends GenHT_SkLincTourokuInfo {

    private static final long serialVersionUID = 1L;

    public HT_SkLincTourokuInfo() {
    }

    public HT_SkLincTourokuInfo(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SkLincTourokuInfo.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

