CREATE TABLE BT_Gknyknmeisai (
     hrkmdatakbn1                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分１ */
     hrkmsyubetucd                                      VARCHAR     (2)                                                                 ,  /* （振込用）種別コード */
     hrkmcdkbn                                          VARCHAR     (1)                                                                 ,  /* （振込用）コード区分 */
     hrkmsakuseiymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （振込用）作成日 */
     hrkmrenrakuymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （振込用）連絡日 */
     hrkmrenrakukaisuu                                  VARCHAR     (2)                                                       NOT NULL  ,  /* （振込用）連絡回数 */
     hrkmknjyymdfrom                                    VARCHAR     (8)                                                                 ,  /* （振込用）勘定日（自） */
     hrkmknjyymdto                                      VARCHAR     (8)                                                                 ,  /* （振込用）勘定日（至） */
     hrkmbankcd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* （振込用）銀行番号 */
     hrkmbanknmej                                       VARCHAR     (15)                                                                ,  /* （振込用）銀行名（英字） */
     hrkmsitencdtori                                    VARCHAR     (3)                                                                 ,  /* （振込用）支店コード（取次） */
     hrkmsitennmejtori                                  VARCHAR     (15)                                                                ,  /* （振込用）支店名（英字）（取次） */
     hrkmshitencd                                       VARCHAR     (3)                                                       NOT NULL  ,  /* （振込用）支店番号 */
     hrkmsitennmej                                      VARCHAR     (15)                                                                ,  /* （振込用）支店名（英字） */
     hrkmyokinkbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* （振込用）預金種目区分 */
     hrkmkouzano                                        VARCHAR     (10)                                                      NOT NULL  ,  /* （振込用）口座番号 */
     hrkmkznmej                                         VARCHAR     (40)                                                                ,  /* （振込用）口座名（英字） */
     hrkmzndktuukasyu                                   VARCHAR     (3)                                                       NOT NULL  ,  /* （振込用）残高通貨種類 */
     hrkmzndkssketa                                     VARCHAR     (1)                                                                 ,  /* （振込用）残高小数桁 */
     hrkmgktrhkmaezndk                                  VARCHAR     (15)                                                                ,  /* （振込用）外貨取引前残高 */
     hrkmkasikosikbn                                    VARCHAR     (1)                                                                 ,  /* （振込用）貸越区分 */
     hrkmyobiv86                                        VARCHAR     (86)                                                                ,  /* （振込用）予備項目Ｖ８６ */
     hrkmdatakbn2                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分２ */
     hrkmdtrecordkbn1                                   VARCHAR     (2)                                                                 ,  /* （振込用）データレコード区分１ */
     hrkmdtrecordkousei                                 VARCHAR     (2)                                                                 ,  /* （振込用）データレコード構成 */
     hrkmsyorino1                                       VARCHAR     (8)                                                       NOT NULL  ,  /* （振込用）処理通番１ */
     hrkmknjyymd                                        VARCHAR     (8)                                                                 ,  /* （振込用）勘定日 */
     hrkmksnymd                                         VARCHAR     (8)                                                                 ,  /* （振込用）起算日 */
     hrkmiribaraikbn                                    VARCHAR     (1)                                                                 ,  /* （振込用）入払区分 */
     hrkmtrhkkbn                                        VARCHAR     (2)                                                                 ,  /* （振込用）取引区分 */
     hrkmtrhktuukasyu                                   VARCHAR     (3)                                                                 ,  /* （振込用）取引通貨種類 */
     hrkmtrhkssketa                                     VARCHAR     (1)                                                                 ,  /* （振込用）取引小数桁 */
     hrkmgktrhkgk                                       VARCHAR     (15)                                                                ,  /* （振込用）外貨取引金額 */
     hrkmbanksyoukaino                                  VARCHAR     (16)                                                                ,  /* （振込用）銀行照会番号 */
     hrkmtrhksyoukaino                                  VARCHAR     (32)                                                                ,  /* （振込用）取引先照会番号 */
     hrkmtekiyounaiyouej                                VARCHAR     (48)                                                                ,  /* （振込用）摘要内容（英字） */
     hrkmyobiv103                                       VARCHAR     (103)                                                               ,  /* （振込用）予備項目Ｖ１０３ */
     hrkmdatakbn3                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分３ */
     hrkmdtrecordkbn2                                   VARCHAR     (2)                                                                 ,  /* （振込用）データレコード区分２ */
     hrkmdtkouseikbn                                    VARCHAR     (2)                                                                 ,  /* （振込用）データ構成区分 */
     hrkmtrkscd                                         VARCHAR     (1)                                                                 ,  /* （振込用）取消コード */
     hrkmsyorino2                                       VARCHAR     (4)                                                                 ,  /* （振込用）処理通番２ */
     hrkmbanksyoukaino2                                 VARCHAR     (16)                                                                ,  /* （振込用）銀行照会番号２ */
     hrkmsimukeymd                                      VARCHAR     (8)                                                                 ,  /* （振込用）仕向日 */
     hrkmsetujyuymd                                     VARCHAR     (8)                                                                 ,  /* （振込用）接受日 */
     hrkmsoukinsyu                                      VARCHAR     (1)                                                                 ,  /* （振込用）送金種類区分 */
     hrkmvalueymd                                       VARCHAR     (8)                                                                 ,  /* （振込用）バリュー日 */
     hrkmskntuukasyu                                    VARCHAR     (3)                                                                 ,  /* （振込用）送金通貨種類 */
     hrkmsknssketa                                      VARCHAR     (1)                                                                 ,  /* （振込用）送金小数桁 */
     hrkmgksoukingk                                     VARCHAR     (15)                                                                ,  /* （振込用）外貨送金額 */
     hrkmirninnmej                                      VARCHAR     (140)                                                               ,  /* （振込用）依頼人名（英字） */
     hrkmyobiv40                                        VARCHAR     (40)                                                                ,  /* （振込用）予備項目Ｖ４０ */
     hrkmdatakbn4                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分４ */
     hrkmdtrecordkbn3                                   VARCHAR     (2)                                                                 ,  /* （振込用）データレコード区分３ */
     hrkmdourecordsuu1                                  VARCHAR     (4)                                                                 ,  /* （振込用）同種レコード数１ */
     hrkmdourecordno1                                   VARCHAR     (4)                                                                 ,  /* （振込用）同種レコード番号１ */
     hrkmkahensuu1                                      VARCHAR     (2)                                                                 ,  /* （振込用）可変項目数１ */
     hrkmkahenketa1                                     VARCHAR     (3)                                                                 ,  /* （振込用）可変項目桁数１ */
     hrkmkahen1                                         VARCHAR     (234)                                                               ,  /* （振込用）可変項目１ */
     hrkmdatakbn5                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分５ */
     hrkmdtrecordkbn4                                   VARCHAR     (2)                                                                 ,  /* （振込用）データレコード区分４ */
     hrkmdourecordsuu2                                  VARCHAR     (4)                                                                 ,  /* （振込用）同種レコード数２ */
     hrkmdourecordno2                                   VARCHAR     (4)                                                                 ,  /* （振込用）同種レコード番号２ */
     hrkmkahensuu2                                      VARCHAR     (2)                                                                 ,  /* （振込用）可変項目数２ */
     hrkmkahenketa2                                     VARCHAR     (3)                                                                 ,  /* （振込用）可変項目桁数２ */
     hrkmkahen2                                         VARCHAR     (234)                                                               ,  /* （振込用）可変項目２ */
     hrkmdatakbn6                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分６ */
     hrkmdtrecordkbn5                                   VARCHAR     (2)                                                                 ,  /* （振込用）データレコード区分５ */
     hrkmdourecordsuu3                                  VARCHAR     (4)                                                                 ,  /* （振込用）同種レコード数３ */
     hrkmdourecordno3                                   VARCHAR     (4)                                                                 ,  /* （振込用）同種レコード番号３ */
     hrkmkahensuu3                                      VARCHAR     (2)                                                                 ,  /* （振込用）可変項目数３ */
     hrkmkahenketa3                                     VARCHAR     (3)                                                                 ,  /* （振込用）可変項目桁数３ */
     hrkmkahen3                                         VARCHAR     (234)                                                               ,  /* （振込用）可変項目３ */
     hrkmrensakuseiymd                                  VARCHAR     (8)                                                                 ,  /* （振込用）連動元作成日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_Gknyknmeisai ADD CONSTRAINT PK_Gknyknmeisai PRIMARY KEY (
     hrkmsakuseiymd                                           , /* （振込用）作成日 */
     hrkmrenrakuymd                                           , /* （振込用）連絡日 */
     hrkmrenrakukaisuu                                        , /* （振込用）連絡回数 */
     hrkmbankcd                                               , /* （振込用）銀行番号 */
     hrkmshitencd                                             , /* （振込用）支店番号 */
     hrkmyokinkbn                                             , /* （振込用）預金種目区分 */
     hrkmkouzano                                              , /* （振込用）口座番号 */
     hrkmzndktuukasyu                                         , /* （振込用）残高通貨種類 */
     hrkmsyorino1                                               /* （振込用）処理通番１ */
) ;
