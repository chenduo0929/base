<?xml version="1.0"?>
<recipe>
    <instantiate from="root/src/app_package/Fragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${fragmentName}.java" />

    <instantiate from="root/src/app_package/Contract.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${contractName}.java" />

    <instantiate from="root/src/app_package/Presenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${presenterName}.java" />

    <instantiate from="root/src/app_package/Adapter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${adapterName}.java" />

	<instantiate from="root/res/fragment.xml.ftl"
		to="${escapeXmlAttribute(resOut)}/layout/${contentLayoutName}.xml" />

    <instantiate from="root/res/item.xml.ftl"
        to="${escapeXmlAttribute(resOut)}/layout/${itemLayoutName}.xml" />

    <open file="${escapeXmlAttribute(srcOut)}/${fragmentName}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${contractName}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${presenterName}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${adapterName}.java" />

    <open file="${escapeXmlAttribute(resOut)}/layout/${contentLayoutName}" />

    <open file="${escapeXmlAttribute(resOut)}/layout/${itemLayoutName}" />
</recipe>
