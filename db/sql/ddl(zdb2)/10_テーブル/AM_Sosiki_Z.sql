CREATE TABLE AM_Sosiki_Z (
     sosikicd                                           VARCHAR     (7)                                                       NOT NULL  ,  /* 組織コード */
     sosikinmkbn                                        VARCHAR     (2)                                                                 ,  /* 組織名区分 */
     sosikinm20                                         VARCHAR     (42)                                                                ,  /* 組織名（２０文字） */
     kanjisosikinm20                                    VARCHAR     (42)                                                                ,  /* 漢字組織名（２０文字） */
     sosikihaisiym                                      VARCHAR     (6)                                                                 ,  /* 組織廃止年月 */
     sosikisinsetuym                                    VARCHAR     (6)                                                                 ,  /* 組織新設年月 */
     tougetukeisyouusosikicd                            VARCHAR     (7)                                                                 ,  /* 当月継承組織コード */
     tougetukeisyoueigyoubucd                           VARCHAR     (3)                                                                 ,  /* 当月継承営業推進部コード */
     zengetukeisyousosikicd                             VARCHAR     (7)                                                                 ,  /* 前月継承組織コード */
     zengetukeisyoueigyoubucd                           VARCHAR     (3)                                                                 ,  /* 前月継承営業推進部コード */
     sosikikihontikucd                                  VARCHAR     (8)                                                                 ,  /* 組織基本地区コード */
     sosikikanjikaijyuusyo30                            VARCHAR     (62)                                                                ,  /* 組織漢字下位住所（３０文字） */
     kanjibirunm15                                      VARCHAR     (32)                                                                ,  /* 漢字ビル名称（１５文字） */
     sosikinyuukyokaisuu                                VARCHAR     (3)                                                                 ,  /* 組織入居階数 */
     sosikitelno                                        VARCHAR     (20)                                                                ,  /* 組織電話番号 */
     sosikifaxno                                        VARCHAR     (20)                                                                ,  /* 組織ＦＡＸ番号 */
     kouryokukaisiymd                                   VARCHAR     (8)                                                                 ,  /* 効力開始年月日 */
     hensosikikihontikucd                               VARCHAR     (8)                                                                 ,  /* (変更後)組織基本地区コード */
     henkanjisosikikaijyuusyo30                         VARCHAR     (62)                                                                ,  /* (変更後)漢字組織下位住所（３０文字） */
     henkanjibirunm15                                   VARCHAR     (32)                                                                ,  /* (変更後)漢字ビル名称（１５文字） */
     hensosikinyuukyokaisuu                             VARCHAR     (3)                                                                 ,  /* (変更後)組織入居階数 */
     hensosikitelno                                     VARCHAR     (20)                                                                ,  /* (変更後)組織電話番号 */
     hensosikifaxno                                     VARCHAR     (20)                                                                ,  /* (変更後)組織ＦＡＸ番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_Sosiki_Z ADD CONSTRAINT AM_SosikiPk PRIMARY KEY (
     sosikicd                                                   /* 組織コード */
) ;
