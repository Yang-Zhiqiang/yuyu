CREATE TABLE ZT_OnlineGknyknmeisaiTr (
     ztrdatakbn1                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分１ */
     ztrsyubetucd                                       VARCHAR     (2)                                                                 ,  /* （取込用）種別コード */
     ztrcdkbn                                           VARCHAR     (1)                                                                 ,  /* （取込用）コード区分 */
     ztrsakuseiymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）作成日 */
     ztrrenrakuymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）連絡日 */
     ztrrenrakukaisuu                                   VARCHAR     (2)                                                       NOT NULL  ,  /* （取込用）連絡回数 */
     ztrknjyymdfrom                                     VARCHAR     (8)                                                                 ,  /* （取込用）勘定日（自） */
     ztrknjyymdto                                       VARCHAR     (8)                                                                 ,  /* （取込用）勘定日（至） */
     ztrbankcd                                          VARCHAR     (4)                                                       NOT NULL  ,  /* （取込用）銀行番号 */
     ztrbanknmej                                        VARCHAR     (15)                                                                ,  /* （取込用）銀行名（英字） */
     ztrsitencdtori                                     VARCHAR     (3)                                                                 ,  /* （取込用）支店コード（取次） */
     ztrsitennmejtori                                   VARCHAR     (15)                                                                ,  /* （取込用）支店名（英字）（取次） */
     ztrshitencd                                        VARCHAR     (3)                                                       NOT NULL  ,  /* （取込用）支店番号 */
     ztrsitennmej                                       VARCHAR     (15)                                                                ,  /* （取込用）支店名（英字） */
     ztryokinkbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* （取込用）預金種目区分 */
     ztrkouzano                                         VARCHAR     (10)                                                      NOT NULL  ,  /* （取込用）口座番号 */
     ztrkznmej                                          VARCHAR     (40)                                                                ,  /* （取込用）口座名（英字） */
     ztrzndktuukasyu                                    VARCHAR     (3)                                                       NOT NULL  ,  /* （取込用）残高通貨種類 */
     ztrzndkssketa                                      VARCHAR     (1)                                                                 ,  /* （取込用）残高小数桁 */
     ztrgktrhkmaezndk                                   VARCHAR     (15)                                                                ,  /* （取込用）外貨取引前残高 */
     ztrkasikosikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）貸越区分 */
     ztryobiv86                                         VARCHAR     (86)                                                                ,  /* （取込用）予備項目Ｖ８６ */
     ztrdatakbn2                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分２ */
     ztrdtrecordkbn1                                    VARCHAR     (2)                                                                 ,  /* （取込用）データレコード区分１ */
     ztrdtrecordkousei                                  VARCHAR     (2)                                                                 ,  /* （取込用）データレコード構成 */
     ztrsyorino1                                        VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）処理通番１ */
     ztrknjyymd                                         VARCHAR     (8)                                                                 ,  /* （取込用）勘定日 */
     ztrksnymd                                          VARCHAR     (8)                                                                 ,  /* （取込用）起算日 */
     ztriribaraikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）入払区分 */
     ztrtrhkkbn                                         VARCHAR     (2)                                                                 ,  /* （取込用）取引区分 */
     ztrtrhktuukasyu                                    VARCHAR     (3)                                                                 ,  /* （取込用）取引通貨種類 */
     ztrtrhkssketa                                      VARCHAR     (1)                                                                 ,  /* （取込用）取引小数桁 */
     ztrgktrhkgk                                        VARCHAR     (15)                                                                ,  /* （取込用）外貨取引金額 */
     ztrbanksyoukaino                                   VARCHAR     (16)                                                                ,  /* （取込用）銀行照会番号 */
     ztrtrhksyoukaino                                   VARCHAR     (32)                                                                ,  /* （取込用）取引先照会番号 */
     ztrtekiyounaiyouej                                 VARCHAR     (48)                                                                ,  /* （取込用）摘要内容（英字） */
     ztryobiv103                                        VARCHAR     (103)                                                               ,  /* （取込用）予備項目Ｖ１０３ */
     ztrdatakbn3                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分３ */
     ztrdtrecordkbn2                                    VARCHAR     (2)                                                                 ,  /* （取込用）データレコード区分２ */
     ztrdtkouseikbn                                     VARCHAR     (2)                                                                 ,  /* （取込用）データ構成区分 */
     ztrtrkscd                                          VARCHAR     (1)                                                                 ,  /* （取込用）取消コード */
     ztrsyorino2                                        VARCHAR     (4)                                                                 ,  /* （取込用）処理通番２ */
     ztrbanksyoukaino2                                  VARCHAR     (16)                                                                ,  /* （取込用）銀行照会番号２ */
     ztrsimukeymd                                       VARCHAR     (8)                                                                 ,  /* （取込用）仕向日 */
     ztrsetujyuymd                                      VARCHAR     (8)                                                                 ,  /* （取込用）接受日 */
     ztrsoukinsyu                                       VARCHAR     (1)                                                                 ,  /* （取込用）送金種類区分 */
     ztrvalueymd                                        VARCHAR     (8)                                                                 ,  /* （取込用）バリュー日 */
     ztrskntuukasyu                                     VARCHAR     (3)                                                                 ,  /* （取込用）送金通貨種類 */
     ztrsknssketa                                       VARCHAR     (1)                                                                 ,  /* （取込用）送金小数桁 */
     ztrgksoukingk                                      VARCHAR     (15)                                                                ,  /* （取込用）外貨送金額 */
     ztrirninnm                                         VARCHAR     (140)                                                               ,  /* （取込用）依頼人名 */
     ztryobiv40                                         VARCHAR     (40)                                                                ,  /* （取込用）予備項目Ｖ４０ */
     ztrdatakbn4                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分４ */
     ztrdtrecordkbn3                                    VARCHAR     (2)                                                                 ,  /* （取込用）データレコード区分３ */
     ztrdourecordsuu1                                   VARCHAR     (4)                                                                 ,  /* （取込用）同種レコード数１ */
     ztrdourecordno1                                    VARCHAR     (4)                                                                 ,  /* （取込用）同種レコード番号１ */
     ztrkahensuu1                                       VARCHAR     (2)                                                                 ,  /* （取込用）可変項目数１ */
     ztrkahenketa1                                      VARCHAR     (3)                                                                 ,  /* （取込用）可変項目桁数１ */
     ztrkahen1                                          VARCHAR     (234)                                                               ,  /* （取込用）可変項目１ */
     ztrdatakbn5                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分５ */
     ztrdtrecordkbn4                                    VARCHAR     (2)                                                                 ,  /* （取込用）データレコード区分４ */
     ztrdourecordsuu2                                   VARCHAR     (4)                                                                 ,  /* （取込用）同種レコード数２ */
     ztrdourecordno2                                    VARCHAR     (4)                                                                 ,  /* （取込用）同種レコード番号２ */
     ztrkahensuu2                                       VARCHAR     (2)                                                                 ,  /* （取込用）可変項目数２ */
     ztrkahenketa2                                      VARCHAR     (3)                                                                 ,  /* （取込用）可変項目桁数２ */
     ztrkahen2                                          VARCHAR     (234)                                                               ,  /* （取込用）可変項目２ */
     ztrdatakbn6                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分６ */
     ztrdtrecordkbn5                                    VARCHAR     (2)                                                                 ,  /* （取込用）データレコード区分５ */
     ztrdourecordsuu3                                   VARCHAR     (4)                                                                 ,  /* （取込用）同種レコード数３ */
     ztrdourecordno3                                    VARCHAR     (4)                                                                 ,  /* （取込用）同種レコード番号３ */
     ztrkahensuu3                                       VARCHAR     (2)                                                                 ,  /* （取込用）可変項目数３ */
     ztrkahenketa3                                      VARCHAR     (3)                                                                 ,  /* （取込用）可変項目桁数３ */
     ztrkahen3                                          VARCHAR     (234)                                                               ,  /* （取込用）可変項目３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_OnlineGknyknmeisaiTr ADD CONSTRAINT PK_OnlineGknyknmeisaiTr PRIMARY KEY (
     ztrsakuseiymd                                            , /* （取込用）作成日 */
     ztrrenrakuymd                                            , /* （取込用）連絡日 */
     ztrrenrakukaisuu                                         , /* （取込用）連絡回数 */
     ztrbankcd                                                , /* （取込用）銀行番号 */
     ztrshitencd                                              , /* （取込用）支店番号 */
     ztryokinkbn                                              , /* （取込用）預金種目区分 */
     ztrkouzano                                               , /* （取込用）口座番号 */
     ztrzndktuukasyu                                          , /* （取込用）残高通貨種類 */
     ztrsyorino1                                                /* （取込用）処理通番１ */
) ;
