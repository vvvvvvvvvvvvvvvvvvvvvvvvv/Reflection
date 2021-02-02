package ReflectionHomeWork;

import java.lang.reflect.Method;

class MethodsPriority {
    public Method method;
    public Integer priority;

    public MethodsPriority(Method method, int priority) {
        this.method = method;
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}
