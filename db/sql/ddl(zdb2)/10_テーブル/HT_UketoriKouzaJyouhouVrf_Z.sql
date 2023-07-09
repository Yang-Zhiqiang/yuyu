CREATE TABLE HT_UketoriKouzaJyouhouVrf_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     uktkzsyubetukbn                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 受取口座種別区分 */
     kzsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 口座種類区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     kouzainfoinputhoryuukbn                            VARCHAR     (1)                                                                 ,  /* 口座情報入力保留区分 */
     kzkykdoukbn                                        VARCHAR     (1)                                                                    /* 口座名義契約者同一人区分 */
)
;

ALTER TABLE HT_UketoriKouzaJyouhouVrf_Z ADD CONSTRAINT PK_UketoriKouzaJyouhouVrf PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     uktkzsyubetukbn                                            /* 受取口座種別区分 */
) ;
