package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SateiIppanHanteiInfo;


/**
 * 査定一般判定情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SateiIppanHanteiInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SateiIppanHanteiInfo<br />
 * @see     PKJT_SateiIppanHanteiInfo<br />
 * @see     QJT_SateiIppanHanteiInfo<br />
 * @see     GenQJT_SateiIppanHanteiInfo<br />
 */
@Entity
public class JT_SateiIppanHanteiInfo extends GenJT_SateiIppanHanteiInfo {

    private static final long serialVersionUID = 1L;

    public JT_SateiIppanHanteiInfo() {
    }

    public JT_SateiIppanHanteiInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SateiIppanHanteiInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiIppanHanteiInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiIppanHanteiInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

