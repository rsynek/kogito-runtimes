/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.jbpm.services.task.audit.commands;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jbpm.query.jpa.data.QueryWhere;
import org.jbpm.query.jpa.impl.QueryCriteriaUtil;
import org.jbpm.services.task.audit.impl.model.AuditTaskImpl;
import org.jbpm.services.task.audit.impl.model.BAMTaskSummaryImpl;
import org.jbpm.services.task.audit.service.TaskAuditQueryCriteriaUtil;
import org.jbpm.services.task.commands.TaskCommand;
import org.jbpm.services.task.commands.TaskContext;
import org.kie.internal.command.Context;
import org.kie.internal.task.api.AuditTask;

@XmlRootElement(name="audit-task-query-command")
@XmlAccessorType(XmlAccessType.FIELD)
public class BAMTaskSummaryQueryCommand extends TaskCommand<List<BAMTaskSummaryImpl>> {

    private static final long serialVersionUID = -6567926743616254900L;

    @XmlElement
    private QueryWhere queryWhere;

    public BAMTaskSummaryQueryCommand() {
        // JAXB constructor
    }

    public BAMTaskSummaryQueryCommand(QueryWhere queryWhere) {
        this.queryWhere = queryWhere;
    }

    public QueryWhere getQueryWhere() {
        return queryWhere;
    }

    public void setQueryWhere( QueryWhere queryWhere ) {
        this.queryWhere = queryWhere;
    }

    @Override
    public List<BAMTaskSummaryImpl> execute(Context cntxt) {
        TaskContext context = (TaskContext) cntxt;
        TaskAuditQueryCriteriaUtil queryCriteriaUtil = new TaskAuditQueryCriteriaUtil(context.getPersistenceContext());
        return queryCriteriaUtil.doCriteriaQuery(getQueryWhere(), BAMTaskSummaryImpl.class);
    }

}
