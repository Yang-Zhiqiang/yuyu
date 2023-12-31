CREATE VIEW ZT_TjtIdouNaiyouTy AS SELECT
     ztyhuho2kyknokbn ,         /* （中継用）普保Ⅱ契約番号区分 */
     ztyhuho2kykno ,         /* （中継用）普保Ⅱ契約番号 */
     ztyrecordsakujyohyouji ,         /* （中継用）レコード削除表示 */
     ztytjtidounaiyouyobi01 ,         /* （中継用）当日異動内容予備０１ */
     ztykhsyouhncd ,         /* （中継用）（契約保全）商品コード */
     ztykhkykjyoutai ,         /* （中継用）（契約保全）契約状態 */
     ztykhkykymd ,         /* （中継用）（契約保全）契約年月日 */
     ztykhyuukousyoumetukbn ,         /* （中継用）（契約保全）有効消滅区分 */
     ztykhsyoumetujiyuu ,         /* （中継用）（契約保全）消滅事由 */
     ztykhsyoumetuymd ,         /* （中継用）（契約保全）消滅年月日 */
     ztykhtsntuukasyu ,         /* （中継用）（契約保全）通算用通貨種類 */
     ztykhtsnyousibous ,         /* （中継用）（契約保全）通算用死亡Ｓ */
     ztykhtsnyouitijip ,         /* （中継用）（契約保全）通算用一時払Ｐ */
     ztykhtsnyounkgns ,         /* （中継用）（契約保全）通算用年金原資 */
     ztykhhrkkkn ,         /* （中継用）（契約保全）払込期間 */
     ztykhsntkhoukbn ,         /* （中継用）（契約保全）選択方法区分 */
     ztykhbosyuuym ,         /* （中継用）（契約保全）募集年月 */
     ztykhkykhhkndouhyouji ,         /* （中継用）（契約保全）契約者被保険者同一表示 */
     ztykhttdktyuuikbn1 ,         /* （中継用）（契約保全）手続注意区分１ */
     ztykhttdktyuuikbn2 ,         /* （中継用）（契約保全）手続注意区分２ */
     ztykhttdktyuuikbn3 ,         /* （中継用）（契約保全）手続注意区分３ */
     ztykhttdktyuuikbn4 ,         /* （中継用）（契約保全）手続注意区分４ */
     ztykhttdktyuuikbn5 ,         /* （中継用）（契約保全）手続注意区分５ */
     ztykhsyouhnsdno ,         /* （中継用）（契約保全）商品世代番号 */
     ztykhkaigomaehrtkykarihyj ,         /* （中継用）（契約保全）介護前払特約有表示 */
     ztykhpyennykntkykarihyj ,         /* （中継用）（契約保全）保険料円入金特約有表示 */
     ztykhtsnyennyknkgk ,         /* （中継用）（契約保全）通算用円入金額 */
     ztykhskmosno ,         /* （中継用）（契約保全）新契約時申込番号 */
     ztykhhouteityotksyhnhyj ,         /* （中継用）（契約保全）法定貯蓄性商品表示 */
     ztykhseiritujitrhkjikakkbn ,         /* （中継用）（契約保全）成立時取引時確認区分 */
     ztykhhrkkeirokbn ,         /* （中継用）（契約保全）払込経路区分 */
     ztytjtidounaiyouyobi02 ,         /* （中継用）当日異動内容予備０２ */
     ztysksyouhncd ,         /* （中継用）（新契約）商品コード */
     ztyskmosymd ,         /* （中継用）（新契約）申込年月日 */
     ztyskkykymd ,         /* （中継用）（新契約）契約年月日 */
     ztysksknnkaisiymd ,         /* （中継用）（新契約）責任開始年月日 */
     ztyskseiritukbn ,         /* （中継用）（新契約）成立区分 */
     ztysksrsyoriymd ,         /* （中継用）（新契約）成立処理年月日 */
     ztyskmfrenflg ,         /* （中継用）（新契約）ＭＦ連動済フラグ */
     ztysksyono ,         /* （中継用）（新契約）証券番号 */
     ztysktsntuukasyu ,         /* （中継用）（新契約）通算用通貨種類 */
     ztysktsnyousibous ,         /* （中継用）（新契約）通算用死亡Ｓ */
     ztysktsnyouitijip ,         /* （中継用）（新契約）通算用一時払Ｐ */
     ztysktsnyounkgns ,         /* （中継用）（新契約）通算用年金原資 */
     ztyskhrkkkn ,         /* （中継用）（新契約）払込期間 */
     ztysksntkhoukbn ,         /* （中継用）（新契約）選択方法区分 */
     ztyskbosyuuym ,         /* （中継用）（新契約）募集年月 */
     ztyskkykhhkndouhyouji ,         /* （中継用）（新契約）契約者被保険者同一表示 */
     ztyskmossyoumetukbn ,         /* （中継用）（新契約）申込消滅区分 */
     ztysksyouhnsdno ,         /* （中継用）（新契約）商品世代番号 */
     ztyskkaigomaehrtkykarihyj ,         /* （中継用）（新契約）介護前払特約有表示 */
     ztyskpyennykntkykarihyj ,         /* （中継用）（新契約）保険料円入金特約有表示 */
     ztysktsnyennyknkgk ,         /* （中継用）（新契約）通算用円入金額 */
     ztyskhrkkeirokbn ,         /* （中継用）（新契約）払込経路区分 */
     ztytjtidounaiyouyobi03 ,         /* （中継用）当日異動内容予備０３ */
     ztynksyouhncd ,         /* （中継用）（年金支払）商品コード */
     ztynknkshrstartymd ,         /* （中継用）（年金支払）年金支払開始年月日 */
     ztynkkykymd ,         /* （中継用）（年金支払）契約年月日 */
     ztynknksyoumetucd ,         /* （中継用）（年金支払）年金消滅コード */
     ztynksyoumtymd ,         /* （中継用）（年金支払）消滅年月日 */
     ztynkshrtuukasyu ,         /* （中継用）（年金支払）支払通貨種類 */
     ztynkteinksyu ,         /* （中継用）（年金支払）定額年金年金種類 */
     ztynktsnnkgns ,         /* （中継用）（年金支払）通算用年金原資 */
     ztynknkukthhkndouhyouji ,         /* （中継用）（年金支払）年金受取人被保険者同一表示 */
     ztynksyouhnsdno ,         /* （中継用）（年金支払）商品世代番号 */
     ztytjtidounaiyouyobi04 ,         /* （中継用）当日異動内容予備０４ */
     ztyhhknmei ,         /* （中継用）被保険者名 */
     ztyknjhhknmei ,         /* （中継用）漢字被保険者名 */
     ztyhhknseiymd ,         /* （中継用）被保険者生年月日 */
     ztyhhknseikbn ,         /* （中継用）被保険者性別区分 */
     ztyhhknnewyno ,         /* （中継用）被保険者新郵便番号 */
     ztyhhknadr ,         /* （中継用）被保険者住所 */
     ztyhhkntelno ,         /* （中継用）被保険者電話番号 */
     ztyhhknsykgycd ,         /* （中継用）被保険者職業コード */
     ztytjtidounaiyouyobi05 ,         /* （中継用）当日異動内容予備０５ */
     ztykyknm ,         /* （中継用）契約者名 */
     ztykjkyknm ,         /* （中継用）漢字契約者名 */
     ztykyksyaseiymd ,         /* （中継用）契約者生年月日 */
     ztytjtidounaiyouyobi06 ,         /* （中継用）当日異動内容予備０６ */
     ztynkuktnm ,         /* （中継用）年金受取人名 */
     ztykjnkuktnm ,         /* （中継用）漢字年金受取人名 */
     ztynenkinuktseiymd ,         /* （中継用）年金受取人生年月日 */
     ztytjtidounaiyouyobi07 ,         /* （中継用）当日異動内容予備０７ */
     ztytsnsknewyno ,         /* （中継用）通信先新郵便番号 */
     ztytsinadr ,         /* （中継用）通信先住所 */
     ztytsintelno ,         /* （中継用）通信先電話番号 */
     ztytjtidounaiyouyobi08 ,         /* （中継用）当日異動内容予備０８ */
     ztysbuktnm1 ,         /* （中継用）死亡受取人名１ */
     ztykjsbuktnm1 ,         /* （中継用）漢字死亡受取人名１ */
     ztysbuktnm2 ,         /* （中継用）死亡受取人名２ */
     ztykjsbuktnm2 ,         /* （中継用）漢字死亡受取人名２ */
     ztysbuktnm3 ,         /* （中継用）死亡受取人名３ */
     ztykjsbuktnm3 ,         /* （中継用）漢字死亡受取人名３ */
     ztysbuktnm4 ,         /* （中継用）死亡受取人名４ */
     ztykjsbuktnm4 ,         /* （中継用）漢字死亡受取人名４ */
     ztytjtidounaiyouyobi09 ,         /* （中継用）当日異動内容予備０９ */
     ztystdrsknm ,         /* （中継用）指定代理請求人名 */
     ztykjstdrsknm ,         /* （中継用）漢字指定代理請求人名 */
     ztykykdairinm ,         /* （中継用）契約者代理人名 */
     ztykjkykdairinm ,         /* （中継用）漢字契約者代理人名 */
     ztytjtidounaiyouyobi10 ,         /* （中継用）当日異動内容予備１０ */
     ztybankcd ,         /* （中継用）銀行番号 */
     ztyshitencd ,         /* （中継用）支店番号 */
     ztyyokinkbn ,         /* （中継用）預金種目区分 */
     ztykouzano7keta ,         /* （中継用）口座番号（７桁） */
     ztykzmeiginmei ,         /* （中継用）口座名義人名 */
     ztykzkykdouhyouji ,         /* （中継用）口座名義契約者同一表示 */
     ztytjtidounaiyouyobi12 ,         /* （中継用）当日異動内容予備１２ */
     ztykzktourokunm1 ,         /* （中継用）家族登録名１ */
     ztykjkzktourokunm1 ,         /* （中継用）漢字家族登録名１ */
     ztykzktourokunm2 ,         /* （中継用）家族登録名２ */
     ztykjkzktourokunm2 ,         /* （中継用）漢字家族登録名２ */
     ztytjtidounaiyouyobi13 ,         /* （中継用）当日異動内容予備１３ */
     ztydairitencd1 ,         /* （中継用）代理店コード１ */
     ztybunwari1 ,         /* （中継用）分担割合１ */
     ztydairitencd2 ,         /* （中継用）代理店コード２ */
     ztybunwari2 ,         /* （中継用）分担割合２ */
     ztyaatukaisosikicd ,         /* （中継用）Ａ扱者組織コード */
     ztybatukaisosikicd ,         /* （中継用）Ｂ扱者組織コード */
     ztytjtidounaiyouyobi11 ,         /* （中継用）当日異動内容予備１１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_TjtIdouNaiyouTy_Z;